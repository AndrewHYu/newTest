package TestAnnotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Andrew  on 2017/5/19.
 */
public class RunTests {
    public static void main(String[] args)throws Exception{
        int tests = 0;
        int passed = 0;
        String classPath = "TestAnnotation.test.Sample";
        Class testClass = Class.forName(classPath);
        for (Method m:
             testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)){

                tests++;
                try{
                    m.invoke(null);
                    passed++;
                }catch (InvocationTargetException e){
                    Throwable exc = e.getCause();
                    System.out.println(m+ " faild: "+exc);
                }catch (Exception e){
                    System.out.println("INVALID @Test: "+m);
                }
            }
        }
        System.out.printf("Passed: %d,Failed :%d%n",passed,tests-passed);
    }

}
