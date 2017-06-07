package generic;


import java.util.Date;

/**
 * Created by 27032 on 2016/8/27.
 */
public class DataInterval extends Pair<Date> {
    /*
    * 还存在一个public void setSecond(Object second) {}方法
    * */
    @Override
    public void setSecond(Date second) {
        if (second.compareTo(getFirst())>=0)
        super.setSecond(second);
    }
}
