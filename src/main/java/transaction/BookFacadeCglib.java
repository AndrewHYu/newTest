package transaction;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Andrew
 * @date 2018/1/10
 */
public class BookFacadeCglib implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Annotation annotation = obj.getClass()
                .getSuperclass()
                .getDeclaredMethod(method.getName(), method.getParameterTypes())
                .getAnnotation(Transaction.class);
        System.out.println("invoke");
        if (annotation == null) {
            proxy.invoke(target, args);
        } else {
            System.out.println("事务开始");
            proxy.invokeSuper(obj, args);
            System.out.println("事务结束");
        }
        return null;
    }
}
