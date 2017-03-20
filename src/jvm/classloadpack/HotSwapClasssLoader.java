package jvm.classloadpack;

/**
 * Created by Andrew  on 2017/3/17.
 */
public class HotSwapClasssLoader extends ClassLoader {
    public HotSwapClasssLoader() {
        super(HotSwapClasssLoader.class.getClassLoader());
    }
    public Class loadByte(byte[]classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
