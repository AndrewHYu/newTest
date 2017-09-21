package algorithm;

/**
 * @author huangyu
 * @date 2017/9/15
 */
public class LastRemaining {
    public static void main(String[] args) {

    }
    static int LastRemaining(int n,int m){
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2;i <= n;i++)
            last = (last + m) % i;
        return last;
    }
}
