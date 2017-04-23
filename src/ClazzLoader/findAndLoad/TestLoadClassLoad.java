package ClazzLoader.findAndLoad;

/**
 * Created by Andrew  on 2017/4/22.
 */
public class TestLoadClassLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(TestLoadClassLoad.class.getClassLoader());
        LoadClassLoad loadClassLoad = new LoadClassLoad(TestLoadClassLoad.class.getClassLoader());
        System.out.println(loadClassLoad);
        Class c1 = loadClassLoad.loadClass("ClazzLoader.findAndLoad.Hello");
        Class c4= loadClassLoad.loadClass("ClazzLoader.findAndLoad.Hello");
        System.out.println(c1.hashCode());
        System.out.println("--------------------------------");

       LoadClassLoad loadClassLoad2 = new LoadClassLoad(loadClassLoad);
        System.out.println(loadClassLoad2);
        Class c2 = loadClassLoad2.loadClass("ClazzLoader.findAndLoad.Hello");
        System.out.println(c2.getClassLoader().getParent());
        System.out.println(c2.hashCode());
        System.out.println("--------------------------------");

        LoadClassLoad loadClassLoad3 = new LoadClassLoad(TestLoadClassLoad.class.getClassLoader());
        System.out.println(loadClassLoad3);
        Class c3 = loadClassLoad3.loadClass("ClazzLoader.findAndLoad.Hello");
        System.out.println(c3.hashCode());
    }
}
