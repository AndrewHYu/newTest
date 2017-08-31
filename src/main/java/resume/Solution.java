package resume;

/**
 * @author huangyu
 * @date 2017/8/29
 */
public class Solution {
    public static void main(String[] args) {
        int []stream = {5,9,8,7,16};
        handShakeStream(5,3,stream);
    }
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
}
