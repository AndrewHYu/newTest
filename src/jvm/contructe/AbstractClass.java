package jvm.contructe;

/**
 * Created by Andrew  on 2017/3/1.
 */
public abstract class AbstractClass {
    private static N n = new N();   //静态成员变量

    static{                        //静态代码块
        System.out.println(2);
    }

    private M m = new M();       //实例成员变量

    {                            //实例代码块
        System.out.println(6);
    }

    public AbstractClass(){       //无参数的构造函数
        System.out.println(7);
    }

    public AbstractClass(int i){  //有参数的构造函数
        System.out.println(i);
    }

}

class M{
    public M(){
        System.out.println(5);
    }
}

class N{
    public N(){
        System.out.println(1);
    }
}
