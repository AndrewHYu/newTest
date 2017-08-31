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
    public static Integer[][] map;
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ss[] = s.split(" ");//0 N ，1 K
        n = Integer.valueOf(ss[0]);
        k = Integer.valueOf(ss[1]);
        map = new Integer[n][k];

        for (int i = 1;i <= k;i++){
            test(i,n);
        }

        System.out.println(count);
    }
    public static void test(int t,int n1){
        if (map[n - 1][t - 1] != null){
            count += map[n - 1][t - 1];
            return;
        }
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
                if (map[n2 - 1][i - 1] != null){
                    count += map[n2 - 1][i - 1];
                    continue;
                }
                int count1 = count;
                test(i,n2);
                map[n2 - 1][i - 1] = count - count1;
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

    public void testV2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] state = new int[n+1][k+1];
        
        state[0][1] = 1;
        
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum = (sum + state[i-1][j]) % mod;
                }
            for(int j=1; j<=k; j++) {
                int invalid = 0;
                int p = 2;
                while(p*j <= k) {
                    invalid = (invalid + state[i-1][p*j]) % mod;
                    p++;
                    }
                state[i][j] = (sum - invalid + mod) % mod;
                }
            }
        
        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum = (sum + state[n][i]) % mod;
            }
        System.out.println(sum);
        
        scanner.close();
    }
}
