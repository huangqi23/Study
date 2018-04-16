package Thread;

public class RunableStudy implements  RunableStudyInf {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException {
         MyThread runnable =  new  MyThread(new  RunableStudy());
        //观察者模式，就是注册一个对象，然后一起执行
        runnable.add(new  RunableStudy2());
        Thread t = new Thread(runnable);

        t.start();

        System.out.println("aaaa:"+runnable.getNum());
    }

    public void test(int num) {
        System.out.println("hahha"+num);
    }
}
