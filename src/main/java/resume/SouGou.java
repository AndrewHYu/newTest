package resume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author huangyu
 * @date 2017/9/8
 */
public class SouGou {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int n = Integer.valueOf(s);
        double [] a = new double[n];

        double r = 0;
        for (int i = 0;i < n;i++){
            s = in.readLine();
            a[i] = Double.valueOf(s);
            for (int j = 0;j < i;j++){
                double t = a[i] - a[j];
                if (t <= 180){
                    r = Math.max(r,t);
                    if (a[i] - 180 < a[j])
                        break;
                }else {
                    t = 360 - t;
                    r = Math.max(r,t);

                }
            }
        }

        System.out.println(String.format("%.8f\n", r));
        in.close();
    }
}
