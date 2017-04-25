package ClazzLoader.TExtend;

/**
 * Created by Andrew  on 2017/4/25.
 */
public class F3 extends F2 {
    private  F1 parent;
    public F3(F1 parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public void tell() {
        System.out.println("f3 tell");
    }
}
