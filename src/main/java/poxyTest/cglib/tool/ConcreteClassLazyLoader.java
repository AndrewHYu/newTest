package poxyTest.cglib.tool;

import net.sf.cglib.proxy.LazyLoader;
import poxyTest.cglib.bean.PropertyBean;

import java.util.Date;

/**
 * Created by Andrew  on 2017/3/6.
 */
public class ConcreteClassLazyLoader implements LazyLoader {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before lazyLoader...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("zghw");
        propertyBean.setValue(new Date());
        System.out.println("after lazyLoader...");
        return propertyBean;
    }
}
