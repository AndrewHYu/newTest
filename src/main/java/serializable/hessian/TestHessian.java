package serializable.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author huangyu
 * @date 2017/8/23
 * Hessian与Java序列化对比：
 * 相同点：1.都需要实现Serializable接口
 *          2.都不需要调用构造函数
 *
 * 不同点：1.Java序列化serialVersionUID属性值在序列化前后不同反序列化失败
 *          （查看字节文件，Java会带有该属性添加transient无效。
 *          若没有添加该属性会在运行时动态生成，改变类定义该值会改变）
 */
public class TestHessian {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setId(4);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(bytes);
//        SerializerFactory serializerFactory = SerializerFactory.createDefault();
//        out.setSerializerFactory(serializerFactory);
        out.writeObject(user);
        out.close();

        ByteArrayInputStream b = new ByteArrayInputStream(bytes.toByteArray());
        Hessian2Input in = new Hessian2Input(b);
        User u2 = (User) in.readObject();

        //测试serialVersionUID 在hessian中的影响
        serializeUser();
        deserializeUser();

    }


    private static void serializeUser() throws FileNotFoundException, IOException {
        User user = new User();
        user.setId(4);
        // ObjectOutputStream 对象输出流
        Hessian2Output oo = new Hessian2Output(new FileOutputStream(new File("E:/User.txt")));
        oo.writeObject(user);
        System.out.println("User对象序列化成功！");
        oo.close();
    }

    private static User deserializeUser() throws Exception, IOException {
        Hessian2Input in = new Hessian2Input(new FileInputStream(
                new File("E:/User.txt")));
        User customer = (User) in.readObject();
        System.out.println("User对象反序列化成功！");
        return customer;
    }
}
