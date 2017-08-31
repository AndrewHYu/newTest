package resume;


import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/26 45 67 33 21
 */
public class Didi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;

        String ss = in.nextLine();
        String[] sss = ss.split(" ");
        int[] num = new int[sss.length];
        for (int n = 0;n < sss.length;n++) {//注意while处理多个case
            num [n]= Integer.valueOf(sss[n]);
        }
        count = Integer.valueOf(in.nextLine());
        sort(num,0,sss.length - 1);
        System.out.println(num[sss.length-count]);
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
