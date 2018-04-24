package Thread.Synchronized;

public class ClassA implements Runnable{

    @Override
    public synchronized void run() {
        for (int i=0;i<10000;i++){
            System.out.println(i);
        }
    }
}
