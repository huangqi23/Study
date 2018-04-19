package deadlock;

public class LockClassB implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (MainClass.valueB) {
                    System.out.println("B");
                    Thread.sleep(3000);

                    synchronized (MainClass.valueA) {
                        System.out.println("A");
                        Thread.sleep(30000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
