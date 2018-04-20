package Thread.WaitAndNotify;

public class MainClass {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB(classA);
        Thread thread = new Thread(classA);
        Thread thread1 = new Thread(classB);
        thread.start();
        thread1.start();
    }
}
