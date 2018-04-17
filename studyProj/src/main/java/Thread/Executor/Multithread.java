package Thread.Executor;

import java.util.concurrent.*;

public class Multithread {
    public static void main(String[] args) {
        //MyTask只要实现了callable接口，和call 方法
        MyTask myTask = new MyTask();
        MyTask myTask1 = new MyTask();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<RecordInt> future = service.submit(myTask);
        Future<RecordInt> future1 = service.submit(myTask1);
        try {
            System.out.println(future.get().getValue1());
            System.out.println(future1.get().getValue2());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
