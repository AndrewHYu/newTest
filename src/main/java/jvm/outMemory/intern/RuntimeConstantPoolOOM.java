package jvm.outMemory.intern;

/**
 * Created by Andrew  on 2016/10/29.
 * Java中加“”d的字符串都会被加入常量池
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);

        String str3=new String ("lOVE");
        System.out.println(str3.intern()==str3);

        String str4=new StringBuilder("ja").toString();
        System.out.println(str2.substring(0,1));
        System.out.println(str4.intern()==str4);

    }
}
