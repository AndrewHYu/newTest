package enumTest;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created by Andrew  on 2017/5/6.
 */
public class PayrollDayTest {
    public static void main(String[] args) {
        Byte b = new Byte("");

        System.out.println(b);
        PayrollDay.SATURDAY.pay(1,1);
//        PayrollDay.MONDAY.pay(1,1);
        System.out.println(PayrollDay.valueOf("MONDAY"));
//        PayrollDay.valueOf("DDD");
        EnumSet enumSet = EnumSet.noneOf(PayrollDay.class);
        enumSet.add(PayrollDay.FRIDAY);
        enumSet.of(PayrollDay.SATURDAY);
        Iterator<PayrollDay> iterator = enumSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
