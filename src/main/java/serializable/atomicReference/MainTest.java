package serializable.atomicReference;

import java.io.*;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Foo foo = new Foo(3,6);
        FileOutputStream fos = new FileOutputStream(new File("C:\\test\\foo.class"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(foo);

        oos.close();

        FileInputStream fis = new FileInputStream(new File("C:\\test\\foo.class"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Foo foo1 = (Foo) ois.readObject();

        ois.close();
        System.out.println(foo1.getX());

    }
}
