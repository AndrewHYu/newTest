package jvm.outMemory.stakeOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2016/10/29.
 */
public class HeepOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while (true){
            System.out.println("NEW");
            list.add(new OOMObject());
        }
    }
}
