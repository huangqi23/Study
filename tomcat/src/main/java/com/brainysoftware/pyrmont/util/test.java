package com.brainysoftware.pyrmont.util;

public class test {
    private int a =11;

    public static void main(String[] args) {
        test test1 = new test();
        test1.testA();
    }

    public void testA(){
        B b = new B();
        b.testB();
    }

    class  B{
        public void testB(){
            System.out.println(a);
        }
    }
}
