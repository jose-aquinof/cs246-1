package burgener;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (Pattern.compile("[0-9]").matcher(password).find() && (password.length() > 7)){
                    User user = new User();
                    user.setPassword(password);
                    System.out.println(user.getPassword());

                    try {
                        NSALoginController.hashUserPassword(user);
                    }
                    catch (Exception e) {

                    }

                    System.out.println(user.getPassword());
                    System.out.println(user.getSalt());
                    System.out.println(user.getHashedPassword());

                    System.out.print("Enter password: ");
                    String secondPassword = scanner.nextLine();
                    user.setPassword(secondPassword);

                    try {
                        System.out.println("\tPassword Verified: " + NSALoginController.verifyPassword(user));
                    }
                    catch (Exception e) {

                    }
                    done = true;
                }
                else {
                    System.out.println("Weak Password. Have at least 8 characters, one being a digit.");
                }
            }
            catch (Exception e) {

            }
        }
    }
}