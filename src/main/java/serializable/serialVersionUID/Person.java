package serializable.serialVersionUID;

import java.io.Serializable;

/**
 * Created by Andrew  on 2016/10/27.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = -5006266828618438332L;
    //Person类中没有定义serialVersionUID
    private String name;
    private int age;
    //新添加的sex属性
    private String sex;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("constructor");
    }

    public Person(String name, int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /*
21      * @MethodName toString
22      * @Description 重写Object类的toString()方法
23      * @author xudp
24      * @return string
25      * @see java.lang.Object#toString()
26      */
    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}
