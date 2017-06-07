package serializable.serialVersionUID;

import java.io.*;

/**
 * Created by Andrew  on 2016/10/27.
 */
public class TestSerialversionUID {
    public static void main(String[] args) throws Exception {
//        SerializePerson();// 序列化Customer对象
        Person customer = DeserializePerson();// 反序列Person对象
        System.out.println(customer);
    }
    /**
     19      * MethodName: SerializePerson
     20      * Description: 序列化Person对象
     21      * @author xudp
     22      * @throws FileNotFoundException
     23      * @throws IOException
     24      */
    private static void SerializePerson() throws FileNotFoundException, IOException {
        Person customer = new Person("gacl",25);
        // ObjectOutputStream 对象输出流
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
        oo.writeObject(customer);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }
    /**
     37      * MethodName: DeserializePerson
     38      * Description: 反序列Person对象
     39      * @author xudp
     40      * @return
     41      * @throws Exception
     42      * @throws IOException
     43      */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Person.txt")));
        Person customer = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return customer;
    }
}
