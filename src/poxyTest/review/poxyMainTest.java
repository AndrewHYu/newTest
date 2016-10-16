package poxyTest.review;

import poxyTest.review.impl.PeopleImpl;
import poxyTest.review.inter.People;
import poxyTest.review.proxyTest.ProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class poxyMainTest {
    public static void main(String[] args) {
        People p = new PeopleImpl();
        People people = (People) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{People.class},
                new ProxyHandler(p));
        people.test();
//        Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{People.class, User.class},new ProxyHandler())
    }
}
