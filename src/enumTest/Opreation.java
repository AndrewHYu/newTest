package enumTest;

/**
 * Created by Andrew  on 2017/5/6.
 */
public enum Opreation {
    PLUS,MINUS,TIMES,DIVIDE;
    double apply(double x,double y){
        switch (this){
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("Unknown op"+this);
    }
}
