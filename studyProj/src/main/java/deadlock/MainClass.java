package deadlock;

public class MainClass {
    public static Integer valueA = 0;
    public static Integer valueB = 1;

    public static void main(String[] args) {
        Thread thread = new Thread(new LockClassA());
        thread.start();
        Thread thread1 = new Thread(new LockClassB());
        thread1.start();

    }

}
