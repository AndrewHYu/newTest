package readMap;

import aliTest.Test;

import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrew  on 2017/1/6.
 */
public class test {

    boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    ThreadLocal<Integer> df = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return super.initialValue();
        }
    };
    public static void main(String[] args) {
//        Collections.synchronizedMap(new HashMap<Object, Object>())
/*        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Collections.synchronizedMap(new HashMap<>());*/
//        CopyOnWriteArrayList
        Map<String,String>map=new HashMap<>(3);
        map.put("2","2");
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
//        map.forEach();
        Set<Map.Entry<String, String>> entry=map.entrySet();
        Iterator iterator=entry.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public synchronized static void synchronchedStaticTest(){
        System.out.println("into synchronchedStaticTest");
    }

}
class SubTest{
public void t(){
    test.synchronchedStaticTest();
}
        }
