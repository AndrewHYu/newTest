package generic.efffictive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrew  on 2017/5/20.
 */
public class SetArray {
    public static void main(String[] args) {
        Set<String>[]strings = (Set<String>[])new Set[4];
        List<String>[]lists = new ArrayList[5];
        lists[0] = new ArrayList<String>();
        lists[0].add("444");
        System.out.println(lists[0].get(0));

        List<String>[] stringLists =  new ArrayList[1];
        List<Integer> intLists = Arrays.asList(42);
        Object[] objects = stringLists;
        objects[0] = intLists;
        String s = stringLists[0].get(0);
    }
}
