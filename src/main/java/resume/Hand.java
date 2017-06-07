package resume;

import java.util.Scanner;

/**
 * Created by Andrew  on 2017/3/25.
 */
public class Hand {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numStr = in.nextLine();
        String[] numStrArray =numStr.split(" ");


        int n = Integer.valueOf(numStrArray[0]);
        int k = Integer.valueOf(numStrArray[1]);

        String nums  = in.nextLine();
        String[] numsArray  = nums.split(" ");
        Integer[] num = new Integer[n];
        for (int i=0;i<n;i++){
            num[i] = Integer.valueOf(numsArray[i]);
        }

        for (int i=0; i<k;i++){
            int temp=0;
            for (int j=0;j<n;j++){
                if (j==0){
                    temp=(num[j]+num[(j+1)%(n)])%100;
                }else {
                    num[j]=(num[j]+num[(j+1)%(n)])%100;
                }
            }
            num[0]=temp;
        }

        String result = "";
        for (int i=0;i<num.length;i++) {
            if (i==0){
                result=num[i]+"";
            }else {
                result=result+" "+num[i];
            }
        }
        System.out.println(result);
    }
}
