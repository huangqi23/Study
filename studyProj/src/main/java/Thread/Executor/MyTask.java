package Thread.Executor;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i=0;i<20000;i++){
            System.out.println(i);
        }
        return 0;
    }
}
