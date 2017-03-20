package jvm.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2017/3/13.
 */
public class HeapOOM {
    static class OOMObject{

    }
    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PermSize=32M -XX:MaxPermSize=64M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int count = 0;
        while(true){
            try {
                count++;
                list.add(new OOMObject());
                System.out.println("共构造了"+count+"个对象");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
