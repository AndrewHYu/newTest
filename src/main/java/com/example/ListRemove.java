package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Andrew  on 2017/5/24.
 */
public class ListRemove {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3;i<3;i++){
            set.add(i);
            list.add(i);
        }
        for (int i = 0;i<3;i++){
            set.remove(i);
            list.remove(i);////重载导致的混乱lis.remove(Integer.valueOf())
        }
        System.out.println(set+" "+list);
    }
}
