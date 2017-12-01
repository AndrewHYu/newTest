package resume;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author huangyu
 * @date 2017/9/23
 */
public class Mogu {
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            Calendar ca = Calendar.getInstance();
            ca.set(year,month - 1,day);
            System.out.println(ca.get(Calendar.MONTH));
            System.out.println(ca.get(Calendar.DATE));
            System.out.println(ca.get(Calendar.DAY_OF_YEAR));
        }

    }
}
