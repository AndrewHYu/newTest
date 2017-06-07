package resume;

import java.util.Scanner;

/**
 * Created by Andrew  on 2017/3/18.
 */
public class MaxNum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[]strnum = str.split(" ");
        int n= Integer.valueOf(strnum[0]);
        int d= Integer.valueOf(strnum[1]);
        int[][] table = new int[n][n];

        for(int i = 0;i<n;i++){
            String rowStr = in.nextLine();
            String[] rowArray = rowStr.split(" ");
            for (int j = 0;j<n;j++){
                table[i][j]=Integer.valueOf(rowArray[j]);
            }
        }
        int max=0;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                int result=0;
                for (int k=0;k<d;k++){
                    if (j+k<n){
                        result = result+table[i][j+k];
                        if (result>max){
                            max = result;
                        }
                    }
                }
                result=0;
                for (int k=0;k<d;k++){
                    if (j+k<n&&i+k<n) {
                        result = result + table[i + k][j + k];
                        if (result > max) {
                            max = result;
                        }
                    }

                }
                result=0;
                for (int k=0;k<d;k++){

                    if (i+k<n){
                        result = result+table[i+k][j];
                        if (result>max){
                            max = result;
                        }
                    }
                }
                result=0;
                for (int k=0;k<d;k++){

                    if (i-k>0&&j-k>0){
                        result = result+table[i-k][j-k];
                        if (result>max){
                            max = result;
                        }
                    }
                }




            }
        }

        System.out.println(max);
    }
}
