package ClazzLoader.TExtend;

/**
 * Created by Andrew  on 2017/4/25.
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        F1 f1 = new F1();
        System.out.println("f1: "+f1);
//        f1.say();
        F2 f2 = new F2(f1);
        System.out.println("f2: "+f2);
        F3 f3 = new F3(f2);
        System.out.println("f3: "+f3);
        F4 f4 = new F4(f3);
        System.out.println("f4: "+f4);
        f4.say();
    }
}
