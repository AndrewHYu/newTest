package poxyTest.review.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class ProxyHandler implements InvocationHandler {
    private Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        Class type[]=proxy.getClass().getInterfaces();
        for (Class t:
             type) {
            System.out.println(t.getName());

        }
//        proxy.getClass().getDeclaredMethod("toString").invoke(proxy);//此处死循环的原因---read

        return method.invoke(proxied, args);
    }
}
