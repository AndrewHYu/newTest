package jvm.classloadpack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Andrew  on 2017/3/17.
 */
public class JavaClassExecuter {
    public static String execute(byte[]classByte){
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System","jvm.classloadpack.HackSystem");
        HotSwapClasssLoader loader = new HotSwapClasssLoader();
        Class clazz = loader.loadByte(modiBytes);

        try {
             Method method = clazz.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }
}
