package TestAnnotation.docProvider;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author huangyu
 * @date 2017/9/8
 */
public class DocpRrovider {
    @Test
    public void test(){
       /* System.out.println(System.getProperty("user.dir"));
        System.out.println(DocpRrovider.class.getClassLoader().getResource(""));*/

        System.out.println(int.class.isPrimitive());
        System.out.println(Integer.class.isPrimitive());
        System.out.println(create(Bean.class));
    }
    public String create(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder("{");
        for (Field f : fields) {
            // TODO: 2017/9/8 静态属性
            String name = f.getName();
            sb.append("\""+name+"\":");
            Commit c = f.getAnnotation(Commit.class);
            Class type = f.getType();
            if (type.equals(String.class))
                sb.append("\""+c.value()+"\",");
            else if (type.isPrimitive()
                    || type.getName().startsWith("java.lang.")
                    && ! type.equals(Object.class))
                sb.append(0+",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        return sb.toString();
    }
}
