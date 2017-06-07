package ClazzLoader.third;

/**
 * Created by Andrew  on 2016/10/9.
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("java.class.path"));
            Class typeLoad = Class.forName("ClazzLoader.third.TestBean");
            System.out.println(typeLoad.getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
