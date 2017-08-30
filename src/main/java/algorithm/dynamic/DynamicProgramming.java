package algorithm.dynamic;

/**
 * @author huangyu
 * @date 2017/8/17
 */
public class DynamicProgramming {

    int getMostGold(int n,int w,int[] g,int[]p){
        int[] preResult = new int[p.length];
        int[] result = new int[p.length];

        //边界值
        for (int i = 0;i <= n;i++){
            if (i < p[0]){
                preResult[i] = 0;
            }else{
                preResult[i] = g[0];
            }

        }

        //
        for (int i = 0; i < n;i++){
            for (int j = 0;j <= w;j++){
                if (j < p[i]){
                    result[j] = preResult[j];
                }else {
                    result[j] = Math.max(preResult[j],preResult[j - p[i]]+g[i]);
                }
            }
            preResult = result;
        }
        return result[n];
    }
}
