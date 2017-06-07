package stateModel.proxyModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Andrew  on 2016/10/14.
 */
public interface GumballMachineRemote extends Remote {
    int getCount()throws RemoteException;
    int getLocation()throws RemoteException;
    State getState()throws RemoteException;
}
