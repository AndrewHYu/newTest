package resume;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/31
 */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String ss = in.nextLine();
        int n = Integer.valueOf(ss);

        int[] num = new int[n];

        ss = in.nextLine();
        String[] sss = ss.split(" ");
        for (n = 0;n < sss.length;n++) {
            num [n]= Integer.valueOf(sss[n]);
        }
        Arrays.sort(num);
        int count = num[n - 1];
        for (int i = n - 2;i >= 0;i--){
            if (count > 0)
                count -= num[i];

            if (num[i +1] >= num[i])
                continue;
            System.out.println("No");
        }
        if (count > 0)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}
