package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Created by Andrew  on 2016/8/28.
 */
public class Person2 {
    public Person2() {

    }
    public Person2(String name){
        this.name=name;
    }
    public Person2(int age){
        this.age=age;
    }
    public Person2(String name, int age) {
        this.age=age;
        this.name=name;
        System.out.println("In the complex constructor");
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return "["+this.name+"  "+this.age+"]";
    }
    private String name;
    private int age;
}
class hello2{
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("reflect.Person2");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Person2 per1=null;
        Person2 per2=null;
        Person2 per3=null;
        Person2 per4=null;
        //取得全部的构造函数
        /*
        *  demo.getDeclaredFields();获取该类声明属性
        *   Field[] filed1 = demo.getFields();取得实现的接口或者父类的属性
        *
        *   **********#########**********
        *    Field field = demo.getDeclaredField("sex");
        *    field.setAccessible(true);
        *    field.set(obj, "男");
        *
        *
        *    Array.set(数组引用, 0‘下标’, 100‘值’);
        *
        * */
        Constructor<?> cons[]=demo.getConstructors();
        try {
            Constructor<?> con=demo.getConstructor(String.class,int.class);//demo.getMethod()和constructor一样两个
            demo.getInterfaces();
            con.newInstance("harry",6);


        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            per1=(Person2)cons[3].newInstance();
            per2=(Person2)cons[2].newInstance("Rollen");
            per3=(Person2)cons[1].newInstance(20);
            per4=(Person2)cons[0].newInstance("Rollen",20);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);


        System.out.println(cons[0]+"   "+ Modifier.toString(cons[0].getModifiers()));
    }
}
