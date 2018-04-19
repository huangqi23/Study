package Thread.interrupt;

public class SleepClass {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyClass());
        t.start();
        Thread.sleep(2000);
        t.interrupt(); // test interrupt
    }
}

class MyClass implements Runnable{

    @Override
    public void run() {
        System.out.println("a");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("b");
        }
    }
}