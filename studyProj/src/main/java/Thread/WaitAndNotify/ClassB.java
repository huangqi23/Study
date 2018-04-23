package Thread.WaitAndNotify;

public class ClassB implements Runnable {
    private ClassA classA;
    public ClassB(ClassA classA1) {
        classA = classA1;
    }

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i<1000; i++){
            if(i==500){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (classA) {
                    classA.notifyAll();
                }
            }
            System.out.println("B"+i);
        }
    }
}

