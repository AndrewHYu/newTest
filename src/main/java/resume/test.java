package resume;

import java.util.Scanner;

/**
 * Created by Andrew  on 2017/3/17.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(Math.nextAfter(1.0D,2.0D));
        Scanner in = new Scanner(System.in);
        String destStr = in.nextLine();
        String srcStr = "";
        char[] chars = destStr.toCharArray();
        char c = chars[0];
        int b=0;
        for (int i=0;i<chars.length;i++){
            if (c==chars[i]){
                b++;
            }else {
                srcStr = srcStr+b+chars[i-1];
                c=chars[i];
                b=1;
            }
        }
        srcStr = srcStr+b+chars[chars.length-1];
        System.out.println(srcStr);
        System.out.println();
    }
}
