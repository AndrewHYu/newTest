package resume;

import java.util.Scanner;

/**
 * Created by Andrew  on 2017/4/7.
 */
public class AliFTest {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static long caculateSubs(int n, int[][] array) {
        int[] t = new int[n];
        long count = 0;
        for (int i=0;i<n;i++){
            if (array[0][i]==1){
                t[0]=i;
                for (int j = 1;j<n;j++){
                    for (int k = 0;k<n;k++){

                        if (array[j][k]==1){
                            boolean flag=false;
                            for (int c=0;c<j;c++){
                                if (t[c]==k){
                                    flag =true;
                                    break;
                                }
                            }
                            if (flag){
                                continue;
                            }

                            t[j]=k;
                        }
                    }
                    if (t[n-1]!=0|t[n-2]!=0){
                        count++;
                    }
                }
            }

        }
        return  count;
    }

    public static void main(String[] args){
//        System.out.println(1^0);
        Scanner in = new Scanner(System.in);
        long res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _array_rows = 0;
        int _array_cols = 0;
        _array_rows = _n;
        _array_cols = _n;

        int[][] _array = new int[_array_rows][_array_cols];
        for(int _array_i=0; _array_i<_array_rows; _array_i++) {
            for(int _array_j=0; _array_j<_array_cols; _array_j++) {
                _array[_array_i][_array_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = caculateSubs(_n, _array);
        System.out.println(String.valueOf(res));

    }
}
