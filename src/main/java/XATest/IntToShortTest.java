package XATest;

/**
 * Created by Andrew  on 2017/2/10.
 */
public class IntToShortTest {
    public static void main(String[] args) {
        short s=1;
        s+=1;//隐含强制类型转换
//        s=s+1;
        String str="123";
        str+=1;
        str=str+1;
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false


        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1); //true
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2); //false
    Math.round((float) 2.5);
        System.out.println(new IntToShortTest().hashCode());




        String ss1 = "Programming";
        String ss2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(ss1 == ss2);//false
        System.out.println(ss1 == s5);//true
        System.out.println(ss1 == s6);//true  //false
        System.out.println(ss1 == s6.intern());//true
        System.out.println(ss2 == ss2.intern()); //false
         }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
