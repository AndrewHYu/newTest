package algorithm.dynamic;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/23
 */
public class CutRod {
    private int[] a= {0,1,5,8,9,10,17,17,20,24,30,31};//i+1 米的钢条价格

    @Test
    public void test(){
        long start = System.nanoTime();
        int p = cut(a,11); //10 224212 //11 363555
        long end = System.nanoTime();

        System.out.println(p);
        System.out.println("cost time"+(end-start));
    }
    public int cut(int[] p,int n){
        if (n == 0)
            return 0;
        int q = 0;
        for (int i = 1;i <= n;i++){
            q = Math.max(q,p[i] + cut(p,n - i));
        }
        return q;
    }

    @Test
    public void test2(){
        int n = 11;
        int r[] = new int[n + 1];

        long start = System.nanoTime();
        int p = memoizedCut(a,n,r); //10 55263 //11 92764
        long end = System.nanoTime();

        System.out.println(p);
        System.out.println("cost time "+(end-start));
    }
    public int memoizedCut(int[] p,int n,int[] r){
        if (r[n] > 0)
            return r[n];
        if (n == 0)
            return 0;
        int q = 0;
        for (int i = 1;i <= n;i++){
            q = Math.max(q,p[i] + memoizedCut(p,n - i,r));
        }
        r[n] = q;
        return q;
    }

    @Test
    public void test3(){
        int n = 10;
        int r[] = new int[n + 1];

        long start = System.nanoTime();
        int p = buttomCut(a,n,r); //10 39869 //11 38290
        long end = System.nanoTime();

        System.out.println(p);
        System.out.println("cost time "+(end-start));
    }
    public int buttomCut(int[] p,int n,int[] r){
        if (n == 0)
            return 0;
        int q = 0;
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= i;j++){
                q = Math.max(q,p[i] + r[n - i]);
            }
            r[i] = q;
        }
        return q;
    }
}
