package kkhomework;

import java.util.*;

/**
 * Created by Andrew  on 2017/3/9.
 */
public class MoMatch {
    private static Map<String, String> messageMap = new HashMap<String, String>();
    public static void main(String[] args) {

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.hashCode() + "  and " + s2.hashCode());
        Double q = 0.1;
        double f = 0.2;
        Double g = q+f;
        System.out.println(g);
        System.out.println(g.compareTo(0.3));
    }
}
