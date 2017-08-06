package jvm.hash;

/**
 * Created by Andrew  on 2017/3/6.
 */
public class Test {
    public static void main(String[] args) {
        Foo foo=new Foo();
        System.out.println(foo.hashCode());
        System.out.println(System.identityHashCode(foo));
        foo.setId(1);
        System.out.println(foo.hashCode());
        Foo foo1=new Foo();
        System.out.println(foo1.hashCode());
        Child child=new Child();
        System.out.println(child.hashCode());


        System.out.println("+++++++");
        for (int i = 0 ; i < 5 ; i++){
            System.out.println(new Foo().hashCode());
        }
    }
}
