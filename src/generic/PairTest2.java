package generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 27032 on 2016/8/23.
 */
public class PairTest2 {
    public static void main(String[]args){
        GregorianCalendar []birthday=
                {
                        new GregorianCalendar(1906, Calendar.DECEMBER,9),
                        new GregorianCalendar(1815,Calendar.DECEMBER,10),
                        new GregorianCalendar(1903,Calendar.DECEMBER,3),
                        new GregorianCalendar(1910,Calendar.JUNE,22)
                };
        Pair<GregorianCalendar> mm=ArrayAlg2.minMax(birthday);
        System.out.println("min = "+mm.getFirst().getTime());
        System.out.println("max = "+mm.getSecond().getTime());
//        new DataInterval().setSecond(new Date());
        Pair<Date> pair=new DataInterval();
//        pair.setSecond(new Date());
        Method[] methods=pair.getClass().getMethods();
        try {
            Person p=new Person();
            Field first=Person.class.getDeclaredField("age");
            first.setAccessible(true);
            first.set(p,3);
            System.out.println(p.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Method m :
                methods) {
            String para= m.getParameterTypes().length>0?  m.getParameterTypes()[0].getName() :" ";
            System.out.println(Modifier.toString(m.getModifiers())+" "+m.getReturnType()+" "+m.getName()+"("+para+")");
        }
        Pair<String>[] table=(Pair<String>[]) new Pair<?>[10];
    }
}
class ArrayAlg2{
    public static <T extends Comparable>Pair<T>minMax(T[]a){
        if (a==null||a.length==0)return null;
        T min=a[0];
        T max=a[0];
        for (int i=1;i<a.length;i++){
            if (min.compareTo(a[i])>0)min=a[i];
            if (max.compareTo(a[i])<0)max=a[i];
        }
        return new Pair<>(min,max);
    }
}
