package ClazzLoader.findAndLoad;

import java.io.*;

/**
 * Created by Andrew  on 2017/4/22.
 */
public class FindClassLoad extends ClassLoader {
    //C:\java\lang\String.class 不能通过安全校验
    private final String rootDir = "C:\\";

    //不设置父类加载器默认系统类加载器，
    // 强行设置为null，则为启动类加载器
    // 重载此方法方便调试。更符合规范
    public FindClassLoad(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name){

        //不需要，ClassLoader.loadClass已经完成。并且线程安全
        //Class c = findLoadedClass(name);
        String path =  rootDir + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        byte[] buffer=null;
        try {
            InputStream in = new FileInputStream(path);
            buffer = new byte[in.available()];
            in.read(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,buffer,0,buffer.length);
    }
}
