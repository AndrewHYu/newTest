package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangyu
 * @date 2017/9/26
 */
public class InitializerError {
    public static Map m = new HashMap<String,String>(){{m.put("a","2");}};
    public static void main(String[] args) {
        Integer isInt = (Integer) m.get("a");
        System.out.println(isInt);
    }
}
