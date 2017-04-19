package jvm.finalize;

/**
 * Created by Andrew  on 2017/4/19.
 */
public class MainTest {

    public static void main(String[] args) {
        TestObject m =null;
        TestObject t = new TestObject(m);
        t = null;
        System.gc();
        m = null;
        System.gc();

    }
}
