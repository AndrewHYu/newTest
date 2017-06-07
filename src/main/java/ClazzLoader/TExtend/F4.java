package ClazzLoader.TExtend;

/**
 * Created by Andrew  on 2017/4/25.
 */
public class F4 extends F3 {
    private  F1 parent;
    public F4(F1 parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public void say() throws Exception {
        System.out.println("f4");
        parent.say();
//        tell();
    }
}
