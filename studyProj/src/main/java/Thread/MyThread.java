package Thread;

public class MyThread implements Runnable {
    private int num;
    private  RunableStudyInf runableStudyInf[];
    private int count=0;


    public MyThread( RunableStudyInf runableStudyInf1) {
        runableStudyInf = new  RunableStudyInf[2];
        this.runableStudyInf[count] = runableStudyInf1;
        count++;
    }

    public void run() {

        num = 100;
        for (int i=0;i<=count;i++)
        runableStudyInf[i].test(num);
    }

    public int getNum(){
        return  num;
    }
    public void add( RunableStudyInf runableStudyInf1){
        this.runableStudyInf[count] = runableStudyInf1;
    }
}
