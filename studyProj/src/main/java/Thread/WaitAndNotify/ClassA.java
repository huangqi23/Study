package Thread.WaitAndNotify;

public class ClassA implements Runnable {
    @Override
    public synchronized void run() {
        for (int i=0; i<1000; i++){
            if(i==500){
                try {
                    this.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A"+i);
        }
    }
}
