package argorithm.sort;

/**
 * Created by Andrew  on 2017/4/23.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {3,5,2,9,8,6,7,4,1};
        int[] b = {1,2,3,4,5,6,7,9,8};
        sort(b,a.length-1);
    }
    public static void sort(int[]a,int n){
        int exchange = n;
        while (exchange!=0){
            int bound = exchange;
            exchange = 0;
            for (int j = 0;j<bound;j++){
                if (a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    exchange = j;
                }
            }
        }
    }
}
