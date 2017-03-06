package XATest;

/**
 * Created by Andrew  on 2017/2/10.
 */
public class Hello {

    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
        System.out.println(reverse("123"));
        main(null);
    }
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
