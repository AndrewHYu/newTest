package resume;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huangyu
 * @date 2017/8/29
 */
public class Solution {
    public static void main(String[] args) {
        int []stream = {5,9,8,7,16};
        handShakeStream(5,3,stream);
    }
    //不能是负数
    public static int[] handShakeStream(int num,int element,int[]streamNum){
        int[] s = new int[num];
        for (int i = 0;i < num;i++){
            int c =0 ;
            int n = streamNum[i];
            for (c =0; n > 0; ++c)
            {
                n &= (n -1) ; // 清除最低位的1
            }
            s[i] = c;
        }

        for (int i = 0;i < element;i++){
            for (int j = 0;j < num - i - 1;j++){
                if (s[j] > s[j + 1]){
                    int temp = s[j + 1];
                    s[j + 1] = s[j];
                    s[j] = temp;
                    temp = streamNum[j + 1];
                    streamNum[j + 1] = streamNum[j];
                    streamNum[j] = temp;
                }else if (s[j] == s[j + 1] && streamNum[j] > streamNum[j + 1]){
                    int temp = s[j + 1];
                    s[j + 1] = s[j];
                    s[j] = temp;
                    temp = streamNum[j + 1];
                    streamNum[j + 1] = streamNum[j];
                    streamNum[j] = temp;
                }
            }
        }
        return streamNum;
    }
    @Test
    public void test(){
        numberOf1(-1);
    }
    int numberOf1(int n){
        int count = 0;
        if (n < 0){
            n = Math.abs(n);
            count++;
        }
        while (n != 0){
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    double powerWithUnsignedExponent(double base,int exponent){
        if (exponent == 0)
            return 1;
        if (exponent ==1)
            return base;
        double result = powerWithUnsignedExponent(base,exponent >> 1);
        result *= result;
        if ((exponent & 1 )== 1)
            result *= base;
        return result;
    }
    double power(double base,int exponent){
        if (Double.compare(0.0D,base) == 0 && exponent <0)
            return 0.0D;
        int absExponent = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base,absExponent);
        if (exponent < 0)
            result = 1.0D/result;
        return result;
    }

    @Test
    public void testIncrement(){
        int[] a ={1,9,3};
        for (int i = 0;i < 20;i++){
            a = increment(a);
            System.out.println(Arrays.toString(a));
        }
    }
    int[] increment(int[] a){
        int length = a.length - 1;
        for (int i = length;i >= 0;i--){
            a[i] ++;
            if (a[i] >= 10)
                a[i] = 0;
            else
                break;
        }
        return a;
    }
}
