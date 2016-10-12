package ClazzLoader.first;

/**
 * Created by Andrew  on 2016/9/29.
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();

        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}

/*
sun.misc.Launcher$AppClassLoader@e1641c0
sun.misc.Launcher$ExtClassLoader@5736ab79
*/
