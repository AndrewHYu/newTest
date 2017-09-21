package resume;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/9/13
 */
public class Huawei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        String s = in.nextLine();
        String[] ss = s.split("\\.");
        for (int i = 0;i < 4;i++){
            a = (a<<8) | Long.valueOf(ss[i]);
        }
        s = in.nextLine();
        ss = s.split("\\.");
        for (int i = 0;i < 4;i++){
            b = (b<<8) | Long.valueOf(ss[i]);
        }
        s = in.nextLine();
        ss = s.split("\\.");
        for (int i = 0;i < 4;i++){
            c = (c<<8) | Long.valueOf(ss[i]);
        }
        s = in.nextLine();
        ss = s.split("\\.");
        for (int i = 0;i < 4;i++){
            d = (d<<8) | Long.valueOf(ss[i]);
        }

        boolean f = false;
        if ((a <= c) && ( c <= b))
            f = true;
        else if ((c <= a) && (a <= d ))
            f = true;

        if (f)
            System.out.println("Overlap IP");
        else
            System.out.println("No Overlap IP");

    }

    public static void sort(int[] a,int[] b,int i,int j){
        int k = i,z = j,t;
        while (i<j){
            while (i<j&&b[i]<=b[j]){
                j--;
            }
            if (i<j){
                t = b[i];
                b[i] = b[j];
                b[j] = t;

                t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
            while (i<j&&b[i]<b[j]){
                i++;
            }
            if (i<j){
                t = b[i];
                b[i] = b[j];
                b[j] = t;

                t = a[i];
                a[i] = a[j];
                a[j] = t;
                j--;
            }
        }
        if (k<z){
            //可以优化
            sort(a,b,k,i-1);
            sort(a,b,i+1,z);
        }

    }
    public void method2(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int a[]  = new int[ss.length];
        int b[]  = new int[ss.length];

        s = in.nextLine();
        int count = Integer.valueOf(s);
        for (int i = 0;i < ss.length;i++){
            a[i] = Integer.valueOf(ss[i]);
            int length = ss[i].length();
            if (length >= 3)
                b[i] = Integer.valueOf(ss[i].substring(length - 3));
            else
                b[i] = a[i];
        }
        sort(a,b,0,ss.length - 1);
        System.out.println(a[count - 1]);
    }
    public void mehod1(){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        boolean isNa = a < 0;

        char[] s = String.valueOf(a).toCharArray();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int size = s.length;;

        if (isNa)
            size = s.length - 1;
        for (int i = 0;i < size;){
            if (isNa){
                if (i == 0){
                    s1.append(s[i]);
                    s2.append(s[i]);
                }
                s1.append(s[++i]).append(" ");
                s2.append(s[s.length  - i]);
            }else {
                s1.append(s[i++]).append(" ");
                s2.append(s[s.length  - i]);
            }


        }
        s1.deleteCharAt(s1.lastIndexOf(" "));
//        s2.deleteCharAt(s2.lastIndexOf("-"));

        System.out.println(size);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
