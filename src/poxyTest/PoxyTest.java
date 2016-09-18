package poxyTest;

import java.lang.reflect.Proxy;

/**
 * Created by Andrew on 2016/5/28.
 */
public class PoxyTest {
    public static void main(String[]args){
        Object proxyedObject=new UserServiceImpl();
        PoxyUtil poxyUtil=new PoxyUtil(proxyedObject);

        //生成代理对象，对被代理对象的这些接口进行代理
        UserService proxyObject=(UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
        ,UserServiceImpl.class.getInterfaces(),poxyUtil);
        proxyObject.getUser(1);
        proxyObject.addUser(new User());
    }

}
