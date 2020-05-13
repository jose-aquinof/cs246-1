package burgener;

public class Hello {

    public void sayHello() {
        System.out.println("Hello my name is Wesley!");
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        Goodbye goodbye = new Goodbye();
        hello.sayHello();
        goodbye.sayGoodbye();
    }
}