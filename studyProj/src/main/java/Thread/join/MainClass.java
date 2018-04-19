package Thread.join;

public class MainClass {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyClass());
        Thread thread2 = new Thread(new MyClass1());
        Thread thread3 = new Thread(new MyClassInterrupt(thread2));
        thread1.start();
        thread2.start();
        thread3.start(); //join的线程可以被interrupt
        try {
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("c");
        }
    }
}

class MyClass implements Runnable{

    @Override
    public void run() {
        System.out.println("a");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyClass1 implements Runnable{

    @Override
    public void run() {
        System.out.println("b");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyClassInterrupt implements Runnable{
    private Thread thread;
    public MyClassInterrupt(Thread thread1) {
        thread = thread1;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}