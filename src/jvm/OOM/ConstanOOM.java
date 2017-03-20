package jvm.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2017/3/13.
 */
public class ConstanOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }
}
