package stateModel.proxyModel;

import java.rmi.RemoteException;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }
    public void report(){
        try {
            System.out.println("location "+machine.getLocation());
            System.out.println("inventory "+machine.getCount());
            System.out.println("state "+machine.getState());
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
