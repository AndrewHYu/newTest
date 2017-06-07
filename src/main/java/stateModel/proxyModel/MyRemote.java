package stateModel.proxyModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Andrew  on 2016/10/14.
 */
public interface MyRemote extends Remote {
    String sayHello()throws RemoteException;
}
