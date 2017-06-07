package XATest;

/**
 * Created by Andrew  on 2017/2/10.
 */
public class BreakLabelTest {
    public static void main(String[] args) {
        A:for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                System.out.println(j);
                break A;
            }
        }
    }
}
