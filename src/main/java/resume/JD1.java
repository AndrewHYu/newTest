package resume;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/9/8
 */
public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int map[] = new int[n +1];
        map[0] = 1;
        for (int i = 1;i <= n;i++){
            map[i] = map[i - 1];
            for (int j = 1;j < n;j++){
                int t = (int)Math.pow(j,i);
                for (int m = 1; m <= n;m++) {
                    int y = (int) Math.pow(j, m);
                    if (t == y)
                        map[i]++;
                }
            }
            for (int j = 1;j <= i;j++){
                int t = (int)Math.pow(i,j);
                for (int m = i; m <= n;m++){
                    for (int p  = i;p <= n;p++){
                        int y = (int)Math.pow(m,p);
                        if (t == y)
                            map[i]++;
                    }
                }
            }
        }
        System.out.println(map[n-1]);
    }
}
