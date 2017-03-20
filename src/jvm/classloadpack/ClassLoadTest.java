package jvm.classloadpack;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Andrew  on 2017/3/16.
 */
public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is==null){
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = classLoader.loadClass("jvm.classloadpack.ClassLoadTest");
        System.out.println(object.getClass());
        System.out.println(object instanceof jvm.classloadpack.ClassLoadTest);
    }
}
