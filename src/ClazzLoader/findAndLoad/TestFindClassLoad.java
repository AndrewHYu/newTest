package ClazzLoader.findAndLoad;

/**
 * Created by Andrew  on 2017/4/22.
 */
public class TestFindClassLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        FindClassLoad findClassLoad = new FindClassLoad(TestLoadClassLoad.class.getClassLoader());
        System.out.println(findClassLoad);
        Class c1 = findClassLoad.loadClass("ClazzLoader.findAndLoad.Hello");
        System.out.println(c1.hashCode());
        System.out.println("--------------------------------");



        FindClassLoad findClassLoad2 = new FindClassLoad(findClassLoad);
        System.out.println(findClassLoad2);
        Class c2 = findClassLoad2.loadClass("ClazzLoader.findAndLoad.Hello");
        System.out.println(c2.hashCode());
        System.out.println("--------------------------------");

        FindClassLoad findClassLoad3 = new FindClassLoad(TestLoadClassLoad.class.getClassLoader());
        System.out.println(findClassLoad3);
        Class c3 = findClassLoad3.loadClass("ClazzLoader.findAndLoad.Hello");
        System.out.println(c3.hashCode());


    }
}
