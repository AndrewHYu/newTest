package stateModel.proxyModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class GumballMobitorTestDrive {
    public static void main(String[] args) {
        String location="//localhost:8808/seattle.mightygumball.com";

        try {
            GumballMachineRemote machine=(GumballMachineRemote) Naming.lookup(location);
            GumballMonitor monitor=new GumballMonitor(machine);
            monitor.report();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
