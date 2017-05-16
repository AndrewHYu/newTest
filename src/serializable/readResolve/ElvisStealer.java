package serializable.readResolve;

import java.io.Serializable;

/**
 * Created by Andrew  on 2017/5/16.
 */
public class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve(){
        impersonator = payload;
        return new String[]{"A Fool Such as I"};
    }
    private static final long serialVersionUID  = 0;
}
