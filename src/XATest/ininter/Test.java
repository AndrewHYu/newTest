package XATest.ininter;

/**
 * Created by Andrew  on 2016/11/7.
 */
public class Test {
    public static void main(String[] args) {
        Out.Inner inner=new Impl();
        inner.sayHello();

        //内部类限定为默认域,或public
//        OutClass.InnerClass innerrClass=(new OutClass()).new InnerClass();

    }
}
