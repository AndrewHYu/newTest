package serializable.StringList.custmoSerialize;

import java.io.*;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StringList stringList = new StringList();
        FileOutputStream fos = new FileOutputStream(new File("C:\\test\\stringList.class"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        stringList.add("hello");
        stringList.add("world");
        oos.writeObject(stringList);

        oos.close();

        FileInputStream fis = new FileInputStream(new File("C:\\test\\stringList.class"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        StringList foo1 = (StringList) ois.readObject();

        ois.close();
    }
}
