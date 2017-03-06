package poxyTest.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import poxyTest.User;
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

        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();

        Callback noopcb = NoOp.INSTANCE;
        Callback callback1 = new CglibProxy();
        Callback fixValue = new TargetResultFixed();
        Callback[] cbarray=new Callback[]{callback1,noopcb,fixValue};

//        enhancer.setCallback(cglibProxy);
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(callbackFilter);

        UserService o = (UserService)enhancer.create();
        o.getUser(1);
        User user =new User();
        o.addUser(user);
    }
}
