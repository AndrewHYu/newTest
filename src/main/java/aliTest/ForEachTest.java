package aliTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2017/1/23.
 */
public class ForEachTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }
    }
}
