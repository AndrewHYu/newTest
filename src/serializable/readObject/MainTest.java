package serializable.readObject;

import java.util.Date;

/**
 * Created by Andrew  on 2017/5/8.
 */
public class MainTest {
    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pend = mp.end;

        pend.setYear(78);
        System.out.println(p);

        pend.setYear(69);
        System.out.println(p);
    }
}
