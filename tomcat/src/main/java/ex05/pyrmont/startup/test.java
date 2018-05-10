package ex05.pyrmont.startup;

public class test {
    protected int a = 11;
    public static void main(String[] args) {
        //测试一下内部类可以调用外部类的成员变量
        test test1 = new test();
        test1.te();

    }
    public void te(){
        (new SimplePipelineValveContext()).test1();
    }

    protected class SimplePipelineValveContext{
        public void test1(){
            System.out.println(a);
        }
    }
}
