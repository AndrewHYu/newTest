package resume;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/12
 */
public class ATest {
    public static  int count  = 0;
    public static  int k  = 0;
    public static  int n  = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ss[] = s.split(" ");//0 N ，1 K
        n = Integer.valueOf(ss[0]);
        k = Integer.valueOf(ss[1]);

        for (int i = 1;i <= k;i++){
            test(i,n);
        }

        System.out.println(count);
    }
    public static void test(int t,int n1){
        for (int i = 1; i <=k;i++){
            int n2 = n1;
            if (i < t &&((t % i)!= 0)){
                n2--;

            }else if(i >=t){
                n2--;
            }else {
                continue;
            }

            if (n2 == 1 ){
                count++;
            }else{
                test(i,n2);
            }
        }
     /*   for (int i = 1; i <t;i++){
            int n2 = n1;
            if ((t % i)!= 0 ){
                n2--;
                if (n2 == 1 ){
                    count++;
                }else{
                    test(i,n2);
                }

            }

        }
        for (int i = t; i <= k;i++){
            int n2 = n1;
            n2--;
            if (n2 == 1 ){
                count++;
            }else{
                test(i,n2);
            }
        }*/
    }
}
