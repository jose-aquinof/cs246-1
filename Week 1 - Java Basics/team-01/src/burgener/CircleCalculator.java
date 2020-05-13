package burgener;
import java.util.Scanner;

public class CircleCalculator {

    private static final Scanner _scanner = new Scanner(System.in);

    private double getRadius() {
        System.out.print("What is the radius of the circle? ");
        double radius = _scanner.nextDouble();
        return radius;
    }

    private void displayCircumference(double radius) {
        double circumference = Math.PI * (2 * radius);
        System.out.format("\tCircumference: %.2f\n", circumference);
    }

    private void displayArea(double radius) {
        double area = Math.PI * (radius * radius);
        System.out.format("\tArea: %.2f\n", area);
    }

    public static void main(String[] args) {

        CircleCalculator calc = new CircleCalculator();

        double r = calc.getRadius();
        calc.displayCircumference(r);
        calc.displayArea(r);
    }
}

