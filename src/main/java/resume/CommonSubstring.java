package resume;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Andrew  on 2017/7/15.
 */
public class CommonSubstring {
    public static void main(String[] args) {
/*        String re = longestSerialSubstring("aaffffsfabcdfasf","aaaadfsabcdfsdb");
        System.out.println(re);*/

        char p[] = {'a','b','c','a','a','b','c','b'};
        char p2[] = {'a','b','c','d','e','f','g','h'};
        char p3[] = {'a','a','a','a','a','a','a','a'};
        char p4[] = "abcabcacab".toCharArray();
        char p5[] = {'5', '5', '4', '5', '5', '5', '0', '7', '6', '0'};//3, 3, 4, 3, 3, 3, 0, 1, 1, 0
        char p6[] = {'a','b','a','b','a','b','a','b','c'};
        int next[] = new int[p6.length];
        makeNext(p6,next);


        while (true){

            boolean isOver = false;
            Random r = new Random();
            int d = r.nextInt(Integer.MAX_VALUE);
            int re1[] = new int[10];
            int re2[] = new int[10];

            char []s = String.valueOf(d).toCharArray();
            char ps[] = "0000000000".toCharArray();

            for (int i = 0 ; i < s.length ; i++ ){
                ps[i] = s[i];
            }

            makeNext(ps ,re1);
            makeNext2(ps ,re2);

            for ( int i = 0 ; i< re1.length ; i++){
                if (re1[i] != re2[i]){
                    System.out.println(Arrays.toString(ps));
                    isOver = true;
                }
            }
            if (isOver){
                break;
            }
        }
    }
    //求两个字符串的最大公共字串
    public static String longestSerialSubstring(String s1,String s2){
        String res = "";

        int m = s1.length(),n = s2.length();
        int[][] dp = new int[m][n];

        int max = 0;
        int index = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if(c1==c2){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    if(dp[i][j]>max){
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        res = s1.substring(index-max+1,index+1);
        return res;

    }

    public static void makeNext(char [] p,int next[]) {
        int q, k;
        int m = p.length;
        next[0] = 0;
        for (q = 1, k = 0; q < m; ++q) {
            while (k > 0 && p[q] != p[k])   // 1
                k = next[k - 1];            //2
            if (p[q] == p[k]) {             //3
                k++;                        //4
            }
            next[q] = k;                    //5
        }
    }
    public static void makeNext2(char [] p,int next[]){
        int q , k;
        int m = p.length;
        next[0] = 0;
        for (q = 1 , k = 0 ; q < m ; ++q){
            while (k > 0 && p[q] != p[k])
                k = 0;
            if (p[q] == p[k]){
                k++;
            }
            next[q] = k;
        }
    }
}
