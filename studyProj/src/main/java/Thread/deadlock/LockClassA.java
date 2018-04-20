package Thread.deadlock;

public class LockClassA implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (MainClass.valueA) {
                    System.out.println("A");
                    Thread.sleep(3000);

                    synchronized (MainClass.valueB) {
                        System.out.println("B");
                        Thread.sleep(30000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
