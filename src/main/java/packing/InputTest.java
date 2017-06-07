package packing;

import java.io.*;

/**
 * Created by Andrew  on 2016/9/9.
 */
public class InputTest {
    private static String cp = "/src/packing/test.txt";
    public static void main(String[] args) throws IOException{
        int c;
        System.out.println(System.getProperty("user.dir"));
        InputStream in=new LowerCaseInputStream(new FileInputStream("./src/packing/test.txt"));
        while ((c=in.read())>=0){
            System.out.print((char)c);
        }
        in.close();
        //当前类的绝对路径
        System.out.println(InputTest.class.getResource("/").getFile());
        //指定CLASSPATH文件的绝对路径
        System.out.println(InputTest.class.getResource(cp).getFile());
        //指定CLASSPATH文件的绝对路径
        File f = new File(InputTest.class.getResource(cp).getFile());
        System.out.println(f.getPath());

    }
}
