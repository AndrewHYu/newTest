package ClazzLoader.findAndLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Andrew  on 2017/4/22.
 */
public class LoadClassLoad extends ClassLoader{
    //E:\project\newTest\out\production\newTest\java\lang\String.class
    private final String rootDir = "C:\\";
    private ClassLoader parent;

    public LoadClassLoad(ClassLoader parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        //避免重复加载
        Class c = findLoadedClass(name);
        String path =  rootDir + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        byte[] buffer=null;

        if (c!=null) return c;

        File file = new File(path);
        if (!file.exists()) return parent.loadClass(name);

        try {
            InputStream in = new FileInputStream(file);
            buffer = new byte[in.available()];
            in.read(buffer);

            c = defineClass(name,buffer,0,buffer.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return c;
    }
}
