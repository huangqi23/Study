package Thread.Fair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

    // 公平锁案例：
    /*public static void main(String[] args) {
        MyService5 service = new MyService5(true);
        MyThread5[] threads = new MyThread5[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread5(service);
            threads[i].start();
        }
    }*/
    public static void main(String[] args) {
        MyService5 service = new MyService5(false);
        MyThread5[] threads = new MyThread5[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread5(service);
            threads[i].start();
        }
    }
}
class MyThread5 extends Thread {
    private MyService5 service;

    public MyThread5(MyService5 service) {
        this.service = service;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " ：已经运行了....");
        service.test();
    }
}

class MyService5 {
    private Lock lock;

    public MyService5(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void test() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " ：获得了锁");
        lock.unlock();
    }
}