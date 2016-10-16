package stateModel.proxyModel;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachineRemote=null;
        int count;
        try {
            gumballMachineRemote =new GumballMachine(10,"seattle.mightygumball.com");
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            LocateRegistry.createRegistry(8808);
            Naming.rebind("//127.0.0.1:8808/seattle.mightygumball.com",gumballMachineRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
