package jvm.finalize;

/**
 * Created by Andrew  on 2017/4/19.
 */
public class TestObject {
    private TestObject object;
    public TestObject(TestObject o) {
        this.object = o;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("--------finalize------");
        object=this;
        super.finalize();
    }
}
