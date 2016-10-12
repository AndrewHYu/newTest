package ClazzLoader.netLoader;

import com.rubic.framework.execute.java.OperationalData;

import java.lang.reflect.Method;

/**
 * Created by Andrew  on 2016/10/9.
 */
public class CalculatorTest {
    public static void main(String[] args) {
//        String url = "http://localhost:8080/ClassloaderTest/classes";
        String url = "C://rubic";
        NetworkClassLoader ncl = new NetworkClassLoader(url);
        String basicClassName = "rubic.AlgorithmTest";
        String advancedClassName = "com.example.CalculatorAdvanced";
        try {
            Class<?> clazz = ncl.loadClass(basicClassName);  // 加载一个版本的类
            OperationalData calculator = (OperationalData) clazz.newInstance();  // 创建对象
            for (Method method:clazz.getDeclaredMethods()){
                System.out.println(method.getName());
            }
//            clazz = ncl.loadClass(advancedClassName);  // 加载另一个版本的类
//            calculator = (ICalculator) clazz.newInstance();
//            System.out.println(calculator.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
