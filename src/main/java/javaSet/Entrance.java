package javaSet;

import java.util.*;

/**
 * Created by Andrew  on 2017/2/13.
 */
public class Entrance {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap=new LinkedHashMap();
        linkedHashMap.put("a",1);
        linkedHashMap.put("b",2);
        linkedHashMap.put("c",3);
        for (Iterator it = linkedHashMap.keySet().iterator();it.hasNext();){
            Object key=it.next();
             System.out.println( key+"="+ linkedHashMap.get(key));
        }
        System.out.println("========================");
        linkedHashMap.put("b",4);
        for (Iterator it = linkedHashMap.keySet().iterator();it.hasNext();){
            Object key=it.next();
            System.out.println( key+"="+ linkedHashMap.get(key));
        }
        List<String> dataList = new ArrayList<String>();
        dataList.add("one");
        dataList.add("two");

        Object[] listToArray = dataList.toArray();

        // class [Ljava.lang.Object;返回的是Object数组
        System.out.println(listToArray.getClass());
        listToArray[0] = "";
        listToArray[0] = 123;
        listToArray[0] = new Object();
        List list=new ArrayList();
        list.add(22);
        list.add(444);
        String[] objects={"ssss","ddd"};
        Object[] objects1=objects;
        Arrays.asList(0, 1,2,3, 4, 5, 6);
        System.out.println(list.toArray().getClass());
        System.out.println(objects1.getClass());
        boolean[][] data={
            {false,true,false},
                {false,false,true},
                {false,false,false},
        };
        boolean[][] datak={
                {false,false,false},
                {false,false,false},
                {false,false,false},
        };
        for (int k=0;k<3;k++){
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    datak[i][j]=((data[i][k]&&data[k][j])||data[i][j]);
                    if (!data[i][j]){
                        list.add(3);
                    }
//                    System.out.print(datak[i][j]+"   ");
/*                    if ((data[i][k]&&data[k][j])||data[i][j])
                        datak[i][j]=true;*/
                }
                System.out.println();
            }
        }
        System.out.println("========================");
        for (boolean[] s :
                datak) {
            for (boolean b :
                    s) {
                System.out.print(b + "   ");
            }
            System.out.println();
        }
    }
}
