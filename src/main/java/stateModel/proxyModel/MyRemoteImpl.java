package stateModel.proxyModel;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public MyRemoteImpl() throws RemoteException {

    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, 'hey'";
    }

    public static void main(String[] args) {
        try {
            MyRemote service=new MyRemoteImpl();
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            LocateRegistry.createRegistry(8808);
            Naming.rebind("//127.0.0.1:8808/RemoteHello",service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
