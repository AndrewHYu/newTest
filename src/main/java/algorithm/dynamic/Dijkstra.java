package algorithm.dynamic;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/18
 */
public class Dijkstra {
    @Test
    public void test(){
        int[][] a ={
                {0,10,0,30,100},
                {0,0,50,0,0},
                {0,0,0,0,10},
                {0,0,20,0,60},
                {0,0,0,0,0}
        };
        int b[] = {0,0,0,0,0};
//        getShortestPathV1(a);
//        getShortestPathV2(a);
        getShortestPathV3(a,b,0);
    }
    public void getShortestPathV1(int[][]a) {
        int[] b = {0,0,0,0,0};
        for (int k = 0;k < 2;k++){
            for (int i = 0; i < 5;i++){
                for (int j = 0;j < 5;j++){
                    if (a[i][j]>0){ //i -> j 距离
                        int c = b[i]+a[i][j];
                        if (b[j] == 0 || b[j] > c)
                            b[j] = c;
                    }
                }
            }
        }

    }
    public void getShortestPathV2(int[][]a) {
        int[] b = {0,0,0,0,0};
        int[] d = {0,0,0,0,0};
        int n = 0;

        for (int i = 0;d[i%5] >= i ;i++){
            for (int k = 0;k <= n; k++){
                for (int j = 0;j < 5;j++){
                    if (a[i][j] > 0){ //i -> j 距离
                        int c = b[i]+a[i][j];
                        if (b[j] == 0 || b[j] > c){
                            b[j] = c;
                            d[j] = i + 1;
                            n++;
                        }
                    }
                }
            }

        }

    }

    public void getShortestPathV3(int[][]a,int b[],int i) {
        for (int j = 0;j < 5;j++){
            if (a[i][j]>0){ //i -> j 距离
                int c = b[i]+a[i][j];
                if (b[j] == 0 || b[j] > c){
                    b[j] = c;
                    getShortestPathV3(a,b,j);
                }
            }
        }
    }


}
