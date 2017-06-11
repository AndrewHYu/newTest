package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew  on 2017/6/9.
 */
public class ConIterTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterable = map.keySet().iterator();
                while (iterable.hasNext()){
                    String k = iterable.next();
                    System.out.println("thread 1"+k);

                    if (k.equals("b")){
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Iterator<String> iterator = map.keySet().iterator();
                        iterator.hasNext();){
                    String k = iterator.next();
                    System.out.println("thread 2"+k);

                    iterator.remove();

                }

            }
        }).start();
    }
}
