package Thread.ThreadUnSafe;

import java.security.PrivateKey;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadUnSafe implements Runnable {
    //private static int a = 0; //此时是线程不安全的，当使用了AtomicInteger后，这个变量是线程安全的。
    private static AtomicInteger a = new AtomicInteger(0) ;

    @Override
    public void run() {
        for (int i=0;i<100000;i++){
            MyThreadUnSafe.a.addAndGet(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadUnSafe[] list = new MyThreadUnSafe[10];
        Thread[] listthread = new Thread[10];

        MyThreadUnSafe myThreadUnSafe = new MyThreadUnSafe();
        Thread t = new Thread(myThreadUnSafe);
        t.start();
        for (int i=0; i<10; i++){
            list[i] = new MyThreadUnSafe();
            listthread[i] = new Thread(list[i]);
            listthread[i].start();
        }

        Thread.sleep(1000);
        System.out.println(MyThreadUnSafe.a);
    }
}
