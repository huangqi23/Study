package Thread;

public class TestString {
    private static int aa = 100;
    public static void main(String[] args) {
        String strvalue;
        int a;
        strvalue = "a";
        System.out.println(strvalue);
        //第二次赋值的时候strvalue的地址变了，因为jvm已经创建了一个新的对象。
        strvalue = "b";
        System.out.println(strvalue);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aa");
        //第二次赋值的时候stringBuilder的地址没变，因为jvm已经创建了一个新的对象。
        System.out.println(stringBuilder);
        stringBuilder.append("bb");
        System.out.println(stringBuilder);


        TestString.aa--;
        TestString testString = new TestString();
        testString.aa++;
        testString.aa++;
        System.out.println(  aa);

    }
}
