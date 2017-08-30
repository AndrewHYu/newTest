package reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author huangyu
 * @date 2017/8/21
 */
public  class TestConstructor {
    /**
     * 属性值为static，f.get()参数为null也可成功
     */
    private static int id = 5;
    public TestConstructor(int a){
        System.out.println(a);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = TestConstructor.class.getDeclaredField("id");
        f.setAccessible(true);
        int t = (int)f.get(null);
        System.out.println(t);
    }
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        TestConstructor tc = TestConstructor.class.newInstance();
    }
}
