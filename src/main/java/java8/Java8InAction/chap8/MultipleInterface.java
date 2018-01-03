package java8.Java8InAction.chap8;

/**
 * @author Andrew
 * @date 2017/12/25
 */
public class MultipleInterface {

    public static void main(String[] args) {
        doSomeThing((Task) () -> System.out.println("Danger danger!!"));
        doSomeThing((Runnable) () -> System.out.println("Danger danger!!"));
    }
    public static void doSomeThing(Runnable r){r.run();}
    public static void doSomeThing(Task t){t.execute();}
    interface Task{
        void execute();
    }
}
