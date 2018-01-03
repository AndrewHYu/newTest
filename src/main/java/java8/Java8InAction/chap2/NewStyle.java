package java8.Java8InAction.chap2;

import java.util.concurrent.Callable;

/**
 * @author Andrew
 * @date 2017/12/5
 */
public class NewStyle {
    public static void main(String[] args) {
        //认真区分一下这两个版本，表达式和语句
        Thread run = new Thread(() -> {System.out.println("Hello world");});
       // Thread run = new Thread(() -> System.out.println("Hello world"));
        run.start();

    }
    public Callable<String> fetch(){
        return () -> "Tricky example ;-)";
    }
}
