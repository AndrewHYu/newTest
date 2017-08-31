package resume;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/30
 */
public class FirstOneChar {
    @Test
    public void test(){
        find("aAbBABac");
    }
    public void find(String s){
        char [] chars = s.toCharArray();
        int [] count = new int[256];
        for (int i = 0;i < chars.length;i++){
            int j = chars[i] % 256;
            count[j] += 1;
        }
        for (int i = 0;i < 256;i++){
            if (count[i] == 1){
                System.out.println((char) i);
                return;
            }
        }
        System.out.println("no");

    }

    @Test
    public void testFindNumber(){
        int[][] matrix = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,10,15}
        };
        System.out.println(findNumber(matrix,10));
    }
    public boolean findNumber(int [][] matrix,int target){
        int columns = matrix[0].length;
        int rows = matrix.length;
        if (columns > 0 && rows > 0){
            int column = columns - 1;
            int row = 0;
            while (column >= 0 && row < rows){
                if (target > matrix[row][column])
                    row++;
                else if (target == matrix[row][column])
                    return true;
                else
                    column --;
            }
            return false;
        }
        return false;
    }
}
