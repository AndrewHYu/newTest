package resume;

import org.junit.Test;

/**
 * @author huangyu
 * @date 2017/9/12
 *
 *
 * 假设N，我们要计算百位上出现1的次数，将由三部分决定：百位上的数字，百位以上的数字，百位一下的数字。
 *
 * 如果百位上的数字为0，则百位上出现1的次数仅由更高位决定，
 * 比如12013，百位出现1的情况为100~199,1100~1199,2100~2199，…，11100~11199，共1200个。
 * 等于更高位数字乘以当前位数，即12 * 100。
 *
 * 如果百位上的数字大于1，则百位上出现1的次数仅由更高位决定，
 * 比如12213，百位出现1的情况为100~199,1100~1199,2100~2199，…，11100~11199，12100~12199共1300个。
 * 等于更高位数字加1乘以当前位数，即（12 + 1）*100。
 *
 * 如果百位上的数字为1，则百位上出现1的次数不仅受更高位影响，还受低位影响。
 * 例如12113，受高位影响出现1的情况：100~199,1100~1199,2100~2199，…，11100~11199，共1200个，
 * 但它还受低位影响，出现1的情况是12100~12113，共114个，等于低位数字113+1。
 */
public class CountOne {
    @Test
    public void test(){
        int n = 21345;
        System.out.println(countOne(n));
        long start = System.nanoTime();
        System.out.println(countOne2(n));
        long end =  System.nanoTime();
        System.out.println("new Method "+(end-start));
        start = System.nanoTime();
        System.out.println(countOne3(n));
        end =  System.nanoTime();
        System.out.println("old Method "+(end-start));
    }
    public long countOne(long n)
    {
        long count = 0;
        if (n == 0)
            count = 0;
        else if (n > 1 && n < 10)
            count =  1;
        else
        {
            long highest = n;//表示最高位的数字
            int bit = 0;
            while (highest >= 10)
            {
                highest = highest / 10;
                bit++;
            }

            int weight = (int)Math.pow(10, bit);//代表最高位的权重，即最高位一个1代表的大小
            if (highest == 1)
            {
                count = countOne(weight - 1)
                        + countOne(n - weight)
                        + n - weight + 1;
            }
            else
            {
                count = highest * countOne(weight - 1)
                        + countOne(n - highest * weight)
                        + weight;
            }
        }
        return count;
    }
    public long countOne2(long n)
    {
        long count = 0;
        long i = 1;
        long current = 0,after = 0,before = 0;
        while((n / i) != 0)
        {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current > 1)
                count = count + (before + 1) * i;
            else if (current == 0)
                count = count + before * i;
            else if(current == 1)
                count = count + before * i + after + 1;

            i = i * 10;
        }
        return count;

    }
    public long countOne3(long n)
    {
        long i = 0,j = 1;
        long count = 0;
        for (i = 0; i <= n; i++)
        {
            j = i;
            while (j != 0)
            {
                if (j % 10 == 1)
                    count++;
                j = j / 10;
            }
        }
        return count;
    }
}
