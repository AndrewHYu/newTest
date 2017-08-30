package single;

import java.io.Serializable;

/**
 * @author huangyu
 * @date 2017/8/30
 */
public class SingletonInner implements Serializable {
    public static SingletonInner INSTANCE = new SingletonInner();

    protected SingletonInner() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
