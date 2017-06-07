package XATest;

/**
 * Created by Andrew  on 2017/2/9.
 */
public class TestInt {
    public static void main(String[] args) {
        Integer a=10;
        Integer b=10;
        method(a,b);
        System.out.println(a);
    }
    public static void method(Integer a,Integer b){
        a=100;
        b=200;
    }

}
