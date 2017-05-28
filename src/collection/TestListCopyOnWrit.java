package collection;

import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Andrew  on 2017/5/28.
 */
public class TestListCopyOnWrit {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0 ; i < 10;i++){
            list.add(i);
            list1.add(i);
        }
/*        for (Iterator<Integer> it = list.iterator(); it.hasNext();){
            int t = it.next();
            System.out.println(t);
            if (t == 8){
                list.remove(9);
            }
        }*/
        System.out.println(list.hashCode());
        System.out.println(list1.hashCode());

    }
}
