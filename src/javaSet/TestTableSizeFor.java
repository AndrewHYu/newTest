package javaSet;

/**
 * Created by Andrew  on 2017/4/19.
 * 参考链接 http://blog.csdn.net/fan2012huan/article/details/51097331
 */
public class TestTableSizeFor {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(4));
    }
    public static int tableSizeFor(int cap){
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n+1;
    }
}
