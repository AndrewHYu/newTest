package resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by Andrew  on 2017/3/25.
 */
public class Man {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] strArray = str.toCharArray();
        List listA = new ArrayList();
        List listB = new ArrayList();

        int a=0;
        int b=0;
        int c=strArray.length;
        for (int i=0;i<c;i++){
            if (strArray[i]=='B'){
                a=a+(i-listA.size());
                b=b+c-i+listA.size();
                listA.add(i);
            }/*else {
                a=a+c-i-listB.size();
                b=a+(i-listA.size());
                listB.add(i);
            }*/
        }
        System.out.println(Math.min(a,b));
    }
}
