package resume;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Andrew  on 2017/3/17.
 */
public class Horse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numStr = in.nextLine();
        int n= Integer.valueOf(numStr);
        double result=0;
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        for (int i = 1;i<=n;i++){
            result+=1.0/i;
        }
        System.out.println(decimalFormat.format(result));
    }
    public static double get(int n){
        double result=1;
        for (int i=1;i<=n;i++){
            result*=1/n;
        }
        return result*n;
    }
}
