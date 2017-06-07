package javaSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew  on 2017/2/19.
 */
public class TestHashMapKey {
    public static void main(String[] args) {

        Map map = new HashMap();
        SimpleObject simpleObject=new SimpleObject(1,"hy");
        SimpleObject simpleObject2=new SimpleObject(1,"hy");
        map.put(simpleObject,"1");
        System.out.println(map.get(simpleObject));
/*        simpleObject.setId(2);
        simpleObject.setName("hjjhnfjlskdhfk");*/
        System.out.println(map.get(simpleObject));
        System.out.println(map.get(simpleObject2));


        System.out.println(simpleObject.hashCode()+"  "+simpleObject2.hashCode());
    }
}
