package resume;

import org.junit.Test;
import org.python.antlr.op.In;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/26 -23 17 -7 11 -2 1 -34
 */
public class Didi {
        public static void main(String[] args) {
/*            Scanner in = new Scanner(System.in);
            int n = 100;
            int[] num = new int[n];
            int count = 0;
            int preCount = 0;

            String ss = in.nextLine();
            String[] sss = ss.split(" ");
            for (n = 0;n < sss.length;n++) {//注意while处理多个case
                try{
                    num [n]= Integer.valueOf(sss[n]);
                }catch(Exception e){
                    System.out.println(0);
                    return;
                }
            }

            *//*for (int i = 0;i<n;i++){
                count = 0;
                for (int j = i;j < n;j++){
                    count = count + num[j];
                    preCount = Math.max(count,preCount);
                }
            }*//*

            for (int i = 0;i < n;i++){
                if (count < 0)
                    count = num[i];
                else
                    count +=num[i];
                if (count > preCount)
                    preCount = count;
            }
            System.out.println(preCount);*/
/*
            Scanner in = new Scanner(System.in);
            int num = Integer.valueOf(in.nextLine());
            ugly(num);*/

            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            int []a = new int[num];
            for (int i = 0;i < num;i++){
                a[i] = in.nextInt();
            }
            findX(a);
        }
    @Test
    public void test(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ugly(num);
    }
    public static void ugly(int num){
        int []map = new int[num];
        map[0] = 1;
        int count = 1;

        int c2 = 0;
        int c3 = 0;
        int c5 = 0;
        while (count < num){
            int min = Math.min(map[c2] * 2,map[c3] * 3);
            min = Math.min(min,map[c5] * 5);
            map[count] = min;

            while (map[c2] * 2 <= map[count])
                c2++;
            while (map[c3] * 3 <= map[count])
                c3++;
            while (map[c5] * 5 <= map[count])
                c5++;
            count++;
        }
        int result = map[count - 1];
        System.out.println(result);

    }

    @Test
    public void testFindX(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int []a = new int[num];
        for (int i = 0;i < num;i++){
            a[i] = in.nextInt();
        }
        findX(a);
    }
    public static void findX(int []a){
            int count = 0;
            int temp = a[0];
            for (int i = 0;i < a.length -1;){
                if (a[i] == 0){
                    count++;
                    i++;
                    temp = a[i];
                    continue;
                }
                if (a[i] == a[i + 1]){
                    count++;
                    i +=2;
                    if (i < a.length)
                        temp = a[i];
                    continue;
                }
                if ((temp = temp ^ a[i + 1]) == 0){
                    count++;
                    i +=2;
                    if (i < a.length)
                        temp = a[i];
                    continue;
                }
                i++;
            }
            if (a[a.length - 1] == 0)
                count++;
            System.out.println(count);
        }

}
