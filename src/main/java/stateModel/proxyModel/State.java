package stateModel.proxyModel;

import java.io.Serializable;

/**
 * Created by Andrew  on 2016/10/14.
 */
public interface State extends Serializable {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispensed();
}
