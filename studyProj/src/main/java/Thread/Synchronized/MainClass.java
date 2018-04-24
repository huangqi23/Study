package Thread.Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(classB);
        executorService.submit(classB);


    }

    public class  ClassInside{
        public void  test(){
            for (int i = 0;i<100;i++){
                System.out.println(i);
            }
        }
    }
}
