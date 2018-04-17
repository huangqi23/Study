package Thread.Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithread {
    public static void main(String[] args) {
        //MyTask只要实现了callable接口，和call 方法
        MyTask myTask = new MyTask();
        MyTask myTask1 = new MyTask();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(myTask);
        Future<Integer> future1 = service.submit(myTask1);
    }
}
