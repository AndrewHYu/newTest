package resume;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/22
 */
public class Toutiao {
    public static void main(String[] args) {
        room();
    }
    public static void room(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n
        int x = sc.nextInt();//x
        int[] arr = new int[n];

        int [] arr1 = new int[n];
        for (int i = 0;i < n;i++){
            arr[i]  = sc.nextInt();
        }
        arr1 = Arrays.copyOf(arr,n);
        Arrays.sort(arr1);
        int c = arr1[0];
        for (int i = x - 1;;i--){
            if (arr[i] == 0){
                arr[i] = c;
                break;
            }
            if (arr[i] - c >= 0)
                arr[i] -= c ;
//            c++;
            if(i == 0)
                i = n;
        }

        for (int i = 0;i < n - 1;i++)
            System.out.print(arr[i] + " ");
        System.out.println(arr[n - 1]);
    }

    public static void test(){
        Scanner sc = new Scanner(System.in);
        String sn = sc.nextLine();
        int n = Integer.valueOf(sn);//n
        int[][] map = new int[n][2];

        for (int i = 0; i < n; i++){
            String s = sc.nextLine();
            String ss[] = s.split(" "); //x y
            int x = Integer.valueOf(ss[0]);
            int mod = x % n;
            map[mod][0] = x; //x
            int y = Integer.valueOf(ss[1]);
            if (map[mod][1] < y)
            map[mod][1] = y; //y
        }


    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        String sn = sc.nextLine();
        String[] ss = sn.split(" ");
        int n = Integer.valueOf(ss[0]);//n
        int m = Integer.valueOf(ss[1]);//m
        int p = Integer.valueOf(ss[2]);//p

        int[][] map = new int[p][5];

        for (int i = 0; i < p; i++){
            String s = sc.nextLine();
            String ss1[] = s.split(" "); //x y
            map[i][0] = Integer.valueOf(ss1[0]);
            map[i][1] = Integer.valueOf(ss1[1]);
            map[i][2] = Integer.valueOf(ss1[2]);
            map[i][3] = Integer.valueOf(ss1[3]);

        }
        for (int i = 0;i< n; i++){

        }

        for (int i = 0;i< m; i++){

        }

    }
}
