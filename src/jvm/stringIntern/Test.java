package jvm.stringIntern;

/**
 * Created by Andrew  on 2017/3/20.
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("he").append("llo");
        String string = new String(stringBuilder);

        System.out.println(string.intern()==string);
        String string2 = "hello";

        System.out.println(string==string2);
        System.out.println(string.intern()=="hello");

        System.out.println(string.intern()==string2);

    }
}
