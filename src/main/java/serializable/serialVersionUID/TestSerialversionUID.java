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


        Person p = new Person("wwww",32);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bytes);
        oo.writeObject(p);

        ByteArrayInputStream is = new ByteArrayInputStream(bytes.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(is);
        Person p2 = (Person)oi.readObject();

    }

    private static void SerializePerson() throws FileNotFoundException, IOException {
        Person customer = new Person("gacl",25);
        // ObjectOutputStream 对象输出流
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
        oo.writeObject(customer);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Person.txt")));
        Person customer = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return customer;
    }
}
