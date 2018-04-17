package Thread.Executor;

import java.util.concurrent.Callable;

public class MyTask implements Callable<RecordInt> {

    @Override
    public  RecordInt call() throws Exception {
        String strValue;
        synchronized(System.out)  {
            for (int i = 0; i < 20000; i++) {
                System.out.println(i);
            }
        }

        RecordInt recordInt = new RecordInt();
        recordInt.setValue1(1);
        recordInt.setValue2(2);
        return recordInt;
    }
}
