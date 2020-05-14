package burgener;

public class Hello {

    public void sayHello() {
        System.out.println("Hello my name is Wes!");
    }

    public void sayHello2() {
        System.out.println("Hello, Wes, my name is Emma.");
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        Goodbye goodbye = new Goodbye();
        hello.sayHello();
        goodbye.sayGoodbye();
        Hello2 hello2 = new Hello2();
        hello2.sayHello2();
    }
}