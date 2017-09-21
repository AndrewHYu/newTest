package resume;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/9/5
 */
public class Matrix {
    void printMatrixCircle(int[][]matrix,int columns,int rows,int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右
        for (int i = start;i <= endX;i++){
            int number = matrix[start][i];
            System.out.println(number);
        }

        //从右到下
        if (start < endY){
            for (int i = start + 1;i <= endY;i++){
                int number = matrix[i][endX];
                System.out.println(number);
            }
        }


        if (start < endX && start < endY){
            for (int i = endX - 1;i >= start;i--){
                int number = matrix[endY][i];
                System.out.println(number);
            }
        }

        if (start < endX && start < endY - 1){
            for (int i = endY - 1;i >= start + 1;i--){
                int number = matrix[i][start];
                System.out.println(number);
            }
        }
    }
    void printMatrix(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;

        if ( rows <= 0 || columns <= 0){
            return;
        }
        int start = 0;
        while (columns > start * 2 && rows > start * 2){
            printMatrixCircle(matrix,columns,rows,start);
            start++;
        }
    }

    @Test
    public void test(){
        int matrix[][] = {{1,2,3},
                {2,3,4},
                {5,6,7}};
        printMatrix(matrix);
    }
}
