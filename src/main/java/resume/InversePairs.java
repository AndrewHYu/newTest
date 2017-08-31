package resume;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/29
 */
public class InversePairs {

    int MergeArray(int arry[],int start,int mid,int end,int temp[])
    {
        int i = mid;
        int j = end;
        int k = 0;
        int count = 0;

        while(i >= start && j > mid)
        {
            if(arry[i] > arry[j]) {
                temp[k++] = arry[i--];
                count += j - mid;

            }else{
                temp[k++] = arry[j--];
            }
        }
        while(i >= start)
        {
            temp[k++] = arry[i--];
        }

        while(j > mid)
        {
            temp[k++] = arry[j--];
        }

        for(i  = 0;i < k;i++)
            arry[end-i] = temp[i];

        return count;

    }

    int inversePairsCore(int arry[],int start,int end,int temp[])
    {
        int inversions = 0;
        if(start<end)
        {
            int mid = (start+end)/2;
            inversions += inversePairsCore(arry,start,mid,temp);
            inversions += inversePairsCore(arry,mid+1,end,temp);
            inversions += MergeArray(arry,start,mid,end,temp);
        }
        return inversions;
    }


    int inversePairs(int array[],int len)
    {
        int[] temp = new int[len];
        int count = inversePairsCore(array,0,len-1,temp);
        return count;
    }

    @Test
   public void test(){
       int[] num = {7,5,6,4};
       System.out.println(inversePairs(num,4));
   }
}
