package generic.efffictive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2017/5/19.
 */
public class Differ {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("dddd");
        list1.add(1);
        String s1 = (String) list1.get(0);

        List<Object> list2 = new ArrayList<>();
        list2.add("dddd");
        list2.add(1);
        Object s2 = (String) list1.get(0);

/*        List<?> list3 = new ArrayList<>();
        list3.add("dddd");
        list3.add(1);*/

        List<?> list4 = list2;
        String s = (String) list4.get(0);
        char ch = 'a';
        System.out.println(++ch);
    }
}
