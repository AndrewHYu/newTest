package resume;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/31
 */
public class Meituan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int preCount = 0;


        String ss = in.nextLine();
        int n = Integer.valueOf(ss);

        int[] num = new int[n];

        ss = in.nextLine();
        String[] sss = ss.split(" ");
        for (n = 0;n < sss.length;n++) {
            num [n]= Integer.valueOf(sss[n]);
        }

        ss = in.nextLine();
        int k =Integer.valueOf(ss);


        for (int i = 0;i<n;i++){
            count = 0;
            for (int j = i;j < n;j++){
                count = count + num[j];
                if (count != 0 && count % k == 0){
                    preCount = Math.max(preCount,j - i + 1);
//                    System.out.println(count);
                }
                if (preCount == n -i )
                    break;
            }
        }
        System.out.println(preCount);
    }
}
