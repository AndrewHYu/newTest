package resume;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/9/1
 */
public class ReverseMinNumber {
    @Test
    public void test(){
//        int a[] = {1,2,3,4,5};
        int a[] = {1,0,1,1,1};
        int b = min(a);
    }
    public int min(int []numbers){
        int length = numbers.length;
        int index1 = 0;
        int index2 = length - 1;
        int middle = 0;
        while (numbers[index1] >= numbers[index2]){
            if ((index2 - index1) == 1 )
                return numbers[middle];
            middle = (index1 + index2) / 2;
            //10111, 111101
            if (numbers[index1] == numbers[index2] && numbers[middle] == numbers[index2])
                return MinInOrder(numbers,index1,index2);
            if (numbers[middle] >= numbers[index1])
                index1 = middle;
            else if (numbers[middle] <= numbers[index2])
                index2 = middle;
        }
        return numbers[middle];
    }
    public int MinInOrder(int[] numbers,int index1,int index2){
        int result = numbers[index1];
        for (int i = index1 + 1;i <= index2; i++){
            if (result > numbers[i])
                result = numbers[i];
        }
        return result;
    }
}
