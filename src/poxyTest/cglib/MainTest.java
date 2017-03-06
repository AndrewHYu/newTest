package poxyTest.cglib;

import net.sf.cglib.proxy.Enhancer;
import poxyTest.UserService;
import poxyTest.UserServiceImpl;

/**
 * Created by Andrew  on 2017/3/6.
 */
public class MainTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService)enhancer.create();
        o.getUser(1);
    }
}
