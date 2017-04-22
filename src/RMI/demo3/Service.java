package RMI.demo3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Andrew  on 2017/4/21.
 */
public interface Service extends Remote {
    String service(String content) throws RemoteException;
}
