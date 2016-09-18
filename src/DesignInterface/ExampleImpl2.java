package DesignInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2016/9/1.
 */
public class ExampleImpl2 implements Example<List<String>> {
    @Override
    public List<String> getContent() {
        return null;
    }
//    @Override
//    public <T> T getContent() {
//        List list=new ArrayList<String>();
//        list.add("ssrrr");
//        T t=(T) list;
//        return t;
//    }

}
