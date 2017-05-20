package TestAnnotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Andrew  on 2017/5/19.
 */
public class RunTest2 {
    public static void main(String[] args)throws Exception {
        int tests = 0;
        int passed = 0;
        String classPath = "TestAnnotation.test.Sample2";
        Class testClass = Class.forName(classPath);
        for (Method m :
                testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {

                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType:
                         excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            System.out.println(excType.getName());
                            break;
                        }
                    }
                    if (passed==oldPassed) {
                        System.out.printf("Test %s failed: %s %n",m,exc);
                    }
                } /*catch (Exception e) {
                    System.out.println("INVALID @Test: " + m);
                }*/
            }
        }
        System.out.printf("Passed: %d,Failed :%d%n", passed, tests - passed);
    }
}
