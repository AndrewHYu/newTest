package ClazzLoader.TExtend;

/**
 * Created by Andrew  on 2017/4/25.
 */
public class F2 extends F1 {
    private F1 parent;
    public F2(F1 parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public void tell() {
        System.out.println("f2 tell");
    }
}
