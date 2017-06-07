package TestAnnotation;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created by Andrew  on 2016/12/7.
 */
@MyAnnotation()
public class TestAnnotation {

    public static void main(String[] args) throws IOException {
        Annotation[] annotations=TestAnnotation.class.getAnnotations();
        for (Annotation annotation :
                annotations) {
            System.out.println(annotation.annotationType().getName());
            if (annotation.annotationType()==MyAnnotation.class){
                System.out.println(((MyAnnotation)annotation).count());
            }
        }
//        System.in.read();
    }
}
