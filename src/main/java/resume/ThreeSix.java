package resume;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/9/20
 */
public class ThreeSix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int max = 0;

        int n = Integer.valueOf(ss[0]);
        int t = Integer.valueOf(ss[1]);
        int arr[] = new int[n];
        for (int i = 0;i < n;i++){
            arr[i] = in.nextInt();
        }
            Arrays.sort(arr);

            int i = n - 2;
            for (;i >=0 && t > arr[i];i--){
                max = max + arr[i];
                t = t - arr[i];
            }

            for (int j = 0 ;j < i && t > arr[j];j++){
                max = max + arr[j];
                t = t - arr[j];
            }
            System.out.println(max + arr[n - 1]);


    }
}
