package poxyTest.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Andrew  on 2017/3/6.
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        Object o1 = methodProxy.invokeSuper(o, objects);
//        method.invoke(o,objects);
        System.out.println(method.getName());
        System.out.println(methodProxy.getSuperName());
        System.out.println("++++++after " + methodProxy.getSuperName() + "++++++");
        return o1;
    }
}
