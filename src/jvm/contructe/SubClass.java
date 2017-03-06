package jvm.contructe;

/**
 * Created by Andrew  on 2017/3/1.
 */
public class SubClass extends AbstractClass {

    private static U u = new U();   //静态成员变量
    static{                         //静态代码块
        System.out.println(3);
    }

    {                              //实例代码块
        System.out.println(8);
    }

    private I i = new I();        //实例成员变量

    public SubClass(){
        super();         //显式调用父类的构造函数;如果不写，也会隐式调用
        System.out.println(10);
    }
}

class I{
    public I(){
        System.out.println(9);
    }
}

class U{
    public U(){
        System.out.println(4);
    }
}
