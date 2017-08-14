package resume;

import org.python.antlr.op.In;

import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/8/12
 */
public class Fruit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ss[] = s.split(" ");//0 房租 ，1 水果， 2钱，3 水果价值
        int x,f,d,p;
        x = Integer.valueOf(ss[0]);
        f = Integer.valueOf(ss[1]);
        d = Integer.valueOf(ss[2]);
        p = Integer.valueOf(ss[3]);
        int count = 0;

        int c = x * f;
        if (c == d){
            count = f;
        }else if (c > d){
            for (int i = 0 ;i < f;i++){
                d = d  - x;
                if (d >= 0){
                    count++;
                }else {
                    break;
                }
            }
        }else {
            d = d - c;
            for (;;){
                d = d  - x - p;
                if (d >= 0){
                    count++;
                }else {
                    break;
                }
            }
            count = count + f;
        }
        System.out.println(count);
    }
}
