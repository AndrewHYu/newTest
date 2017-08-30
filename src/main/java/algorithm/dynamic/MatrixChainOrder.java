package algorithm.dynamic;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/24
 * A(i) = P(i-1)P(i)
 */
public class MatrixChainOrder {
    @Test
    public void test(){
        int n = 6;
        int p[][] = new int[n + 1][n + 1]; //1 - n
        int m[] = {30,35,15,5,10,20,25};
        for (int i = 1;i <= n;i++)
            p[i][i] = 0;
        for (int f = 2;f <= n;f++){
            for (int i = 1;i <= n - f +1;i++){
                int j = i + f - 1;
                p[i][j] = Integer.MAX_VALUE;
                for (int k = i;k <= j-1;k++){
                    int q = p[i][k] + p[k +1][j] + m[i - 1] * m[k] * m[j];
                    if (q < p[i][j]){
                        p[i][j] = q;
                    }
                }
            }
        }
    }

    @Test
    public void test2(){

    }
}
