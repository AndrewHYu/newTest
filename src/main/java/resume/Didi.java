package resume;

import org.python.antlr.op.In;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/26 -23 17 -7 11 -2 1 -34
 */
public class Didi {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = 100;
            int[] num = new int[n];
            int count = 0;
            int preCount = 0;

            String ss = in.nextLine();
            String[] sss = ss.split(" ");
            for (n = 0;n < sss.length;n++) {//注意while处理多个case
                try{
                    num [n]= Integer.valueOf(sss[n]);
                }catch(Exception e){
                    System.out.println(0);
                    return;
                }
            }

            /*for (int i = 0;i<n;i++){
                count = 0;
                for (int j = i;j < n;j++){
                    count = count + num[j];
                    preCount = Math.max(count,preCount);
                }
            }*/

            for (int i = 0;i < n;i++){
                if (count < 0)
                    count = num[i];
                else
                    count +=num[i];
                if (count > preCount)
                    preCount = count;
            }
            System.out.println(preCount);

        }

}
