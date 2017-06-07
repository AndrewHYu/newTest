package jvm.finalize;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew  on 2017/4/19.
 */
public class MainTest {
    TestObject t ;
    public static void main(String[] args) throws InterruptedException {

        MainTest m = new MainTest();
        m.t = new TestObject(m);
        m.t = null;
        //"   通知     "jvm进行一次垃圾回收，是否执行或什么时候有虚拟机收集算法决定
        System.gc();
        //休眠几秒，增加虚拟机垃圾回收的可能性
        TimeUnit.SECONDS.sleep(5);
        if (m.t!=null){
            System.out.println("第一次判断，对象还活着");
        }
        System.out.println("---------------------");

    }
}
