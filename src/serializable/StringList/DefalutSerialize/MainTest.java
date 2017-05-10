package serializable.StringList.DefalutSerialize;

import java.io.*;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        StringList stringList = new StringList();
        //我的电脑大于1257栈溢出 -Xss2048k,或者xms xmx 3000m左右
        for (int i = 0 ;i < 1258;i++){
            stringList.add(i+"");
        }
        FileOutputStream fos = new FileOutputStream(new File("C:\\test\\stringList.class"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(stringList);
    }
}
