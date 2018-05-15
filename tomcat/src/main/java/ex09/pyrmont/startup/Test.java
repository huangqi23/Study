package ex09.pyrmont.startup;

import org.apache.catalina.logger.SystemErrLogger;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ClassA classA = new ClassA();
        classA.setValue(1111);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/a.hq"));
        oos.writeObject(classA);*/


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/a.hq"));
        ClassA classA = (ClassA) inputStream.readObject();
        System.out.println(classA.getValue());
    }
}

class ClassA implements Serializable {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

}
