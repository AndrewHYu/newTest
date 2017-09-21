package resume;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/8/29
 */
public class InversePairs {

    int MergeArray(int array[],int start,int mid,int end,int temp[])
    {
        int i = mid;
        int j = end;
        int k = 0;
        int count = 0;

        while(i >= start && j > mid)
        {
            if(array[i] > array[j]) {
                temp[k++] = array[i--];
                count += j - mid;

            }else{
                temp[k++] = array[j--];
            }
        }
        while(i >= start)
        {
            temp[k++] = array[i--];
        }

        while(j > mid)
        {
            temp[k++] = array[j--];
        }

        for(i  = 0;i < k;i++)
            array[end-i] = temp[i];

        return count;

    }

    int inversePairsCore(int array[],int start,int end,int temp[])
    {
        int inversions = 0;
        if(start<end)
        {
            int mid = (start+end)/2;
            inversions += inversePairsCore(array,start,mid,temp);
            inversions += inversePairsCore(array,mid+1,end,temp);
            inversions += MergeArray(array,start,mid,end,temp);
        }
        return inversions;
    }

    /**
     * 计算一个数组逆序数
     * @param array
     * @param len
     * @return
     */
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

    @Test
    public void testMyMerger(){
        int[] a = {7,5,6,4,8};
        int[] temp = new int[a.length];
        split(a,0,a.length - 1,temp);
    }

    /**
     * 归并排序实现
     * @param a
     * @param start
     * @param end
     * @param temp
     */
    public void split(int[] a,int start,int end, int[]temp){
        int mid = (start + end)/2;
        if (start < end){
            split(a,start,mid,temp);
            split(a,mid + 1,end,temp);
            merger(a,start,mid,end,temp);
        }
        return;
    }
    public void merger(int[]a,int start,int mid,int end,int[]temp){
        int i = 0;
        int k = start;
        int j = mid + 1;
        while (k <= mid && j <= end){
            if (a[k] < a[j]){
                temp[i] = a[k];
                k++;
            }else {
                temp[i] = a[j];
                j++;
            }
            i++;

        }
        for (;k <= mid;k++,i++)
            temp[i] = a[k];
        for (;j <= end;j++,i++)
            temp[i] = a[j];
        for(int m  = 0;m < i;m++)
            a[start++] = temp[m];
    }

}
