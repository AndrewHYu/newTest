package aliTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrew  on 2017/1/23.
 */
public class Test {
    public static void main(String[] args) {
        Integer a=12;
        Integer b=new Integer(12);
        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(a==b);
        a=128;
        b=128;
        System.out.println(a==b);
        System.out.println(a.equals(b));

        String str = "a,b,c,,"; String[] ary = str.split(","); //预期大于3，结果是3
         System.out.println(ary.length);


        List<String> parentList = new ArrayList<String>();

        for(int i = 0; i < 5; i++){
            parentList.add(String.valueOf(i));
        }

        List<String> subList = parentList.subList(1, 3);
        for(String s : subList){
            System.out.println(s);//output: 1, 2
        }

        //non-structural modification by sublist, reflect parentList
        subList.set(0, "new 1");
        for(String s : parentList){
            System.out.println(s);//output: 0, new 1, 2, 3, 4
        }

        //structural modification by sublist, reflect parentList
        subList.add(String.valueOf(2.5));
        for(String s : parentList){
            System.out.println(s);//output:0, new 1, 2,    2.5, 3,    4
        }

        //non-structural modification by parentList, reflect sublist
        parentList.set(2, "new 2");
        for(String s : subList){
            System.out.println(s);//output: new 1, new 2
        }

        //structural modification by parentList, sublist becomes undefined(throw exception)
        parentList.add("undefine");
//        for(String s : subList){
//            System.out.println(s);
//        }
//        subList.get(0);
       String[]strings = parentList.toArray(new String[parentList.size()]);


        String[] str1 = new String[] { "a", "b" };
        List list = Arrays.asList(str1);
        list.add("c");
    }
}
