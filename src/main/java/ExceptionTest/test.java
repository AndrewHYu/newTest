package ExceptionTest;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * Created by Andrew  on 2017/2/10.
 */
public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future f=service.submit(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("inner");
                                    }
                                }
/*                new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
    }*/
    );
        System.out.println(f.get());
        Set<Human> set=new TreeSet<>();
        set.add(new Human(1));
        set.add(new Human(2));
        set.add(new Human(3));
        set.add(new Human(4));
        for(Human stu : set) {
            System.out.println(stu);
        }

        try {
            throw new ExceptionB();
        } catch(ExceptionB e){
            System.out.println("ExampleA");
        } catch(ExceptionA e){
            System.out.println("Exception");
        }
    }
}
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

class Human {

    int id;
    public Human(int id) {
        this.id=id;
    }

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze(); //如改为Annoyance会导致该异常未被捕获
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
