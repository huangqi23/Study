package Thread.join;

public class MainClass2 {
    public static void main(String[] args) {
        Thread thread= new Thread(new MyClass4());
        thread.start();
        Thread thread1 = new Thread(new MyClass3(thread));
        thread1.start();

    }
}

class MyClass3 implements  Runnable{
    private Thread thread;
    public MyClass3(Thread thread1) {
        this.thread = thread1;
    }
    @Override
    public void run() {
        try {
            thread.join(); //test join

            System.out.println("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyClass4 implements  Runnable{

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