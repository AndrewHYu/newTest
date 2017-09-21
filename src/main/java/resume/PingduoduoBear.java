package resume;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2 5
 5 6 10 20 30
 4 34
 3 35
 * @author huangyu
 * @date 2017/9/2
 */
public class PingduoduoBear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0; //bear
        int m = 0; //suger


        String ss = in.nextLine();
        String[] sss = ss.split(" ");
        n = Integer.valueOf(sss[0]);
        m = Integer.valueOf(sss[1]);

        int[] power = new int[m];

        //糖的能量值
        ss = in.nextLine();
        sss = ss.split(" ");
        for (int i = 0;i < m;i++) {
            power [i]= Integer.valueOf(sss[i]);
        }
        Arrays.sort(power);
        //熊的战斗力和饥饿值

        int [] fight = new int[n];
        int [] hungry = new int[n];
        for (int i = 0;i < n;i++) {
            ss = in.nextLine();
            sss = ss.split(" ");
            fight[i] = Integer.valueOf(sss[0]);
            hungry[i] = Integer.valueOf(sss[1]);
        }

        for (int i = 0;i < n;i++){
            int count = 0;
            int bear = n;
            for (int j = 0;j< n;j++){
                if (fight[j] >= count){
                    count = fight[j];
                    bear = j;
                }
            }
            fight[bear] = -1;
            for (int j = m - 1;j >= 0;j--){
                if (power[j] <= hungry[bear] && power[j] != -1){
                    hungry[bear] -=power[j];
                    power[j] = -1;
                }
            }

        }
        for (int i = 0;i < n;i++) {
            System.out.println(hungry[i]);
        }
    }
    @Test
    public void test(){
        System.out.println(xorshit(4));
        System.out.println(xorshit(4));
        System.out.println(xorshit(4));
    }
    static int xorshit(int y){
        y ^= (y << 6);
        y ^= (y >>> 6);
        y ^= (y << 7);
        return y;
    }
}
