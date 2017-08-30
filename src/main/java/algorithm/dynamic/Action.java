package algorithm.dynamic;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/25
 */
public class Action {
    @Test
    public void test(){
        int [][] ac = {{1,3,0,5,3,5,6,8,8,2,12},
                {4,5,6,7,9,9,10,11,12,14,16}}; //开始时间结束时间
        int q = mostAction(ac,16,10);
        System.out.println(q);
    }
    public int mostAction(int[][] ac,int s,int n){
        if (s < ac[1][0])
            return 0;
        int q = 0;
        for (int i = n;i > 0;i--){
            if (s >= ac[1][i])
                q =Math.max(q,Math.max(mostAction(ac,ac[0][i],n-1) + 1,mostAction(ac,s,n-1)))  ;
        }

        return q;
    }
}
