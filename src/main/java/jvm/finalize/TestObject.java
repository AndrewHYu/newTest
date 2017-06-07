package jvm.finalize;

/**
 * Created by Andrew  on 2017/4/19.
 */
public class TestObject {
    MainTest m;
    public TestObject(MainTest m){
        this.m=m;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("--------finalize------");
        m.t=this;
        super.finalize();
    }
}
