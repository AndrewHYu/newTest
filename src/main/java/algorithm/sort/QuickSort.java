package algorithm.sort;

/**
 * Created by Andrew  on 2017/4/23.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,5,2,9,8,6,7,4,1};
        sort(a,0,a.length-1);
    }
    public static void sort(int[] a,int i,int j){
        int k = i,z = j,t;
        while (i<j){
            while (i<j&&a[i]<=a[j]){
                j--;
            }
            if (i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
            while (i<j&&a[i]<a[j]){
                i++;
            }
            if (i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
                j--;
            }
        }
        if (k<z){
            sort(a,k,i-1);
            sort(a,i+1,z);
        }

    }
}
