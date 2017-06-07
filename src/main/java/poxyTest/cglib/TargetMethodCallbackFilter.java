package poxyTest.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by Andrew  on 2017/3/6.
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("getUser")){
            System.out.println("filter method1 ==1");
            return 1;
        }
        if(method.getName().equals("addUser")){
            System.out.println("filter method2 ==0");
            return 0;
        }
        return 0;
    }

}
