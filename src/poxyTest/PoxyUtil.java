package poxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Andrew on 2016/5/28.
 */
public class PoxyUtil implements InvocationHandler{
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do sth before......");
        Object result=method.invoke(target,args);
        System.out.println("do sth after......");
        return result;

    }

    public PoxyUtil(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
