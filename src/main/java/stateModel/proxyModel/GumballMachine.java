package stateModel.proxyModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State state=soldOutState;

    State winnerState;
    int count=0;
    String location;

    public GumballMachine(int count, String location) throws RemoteException{
        this.count = count;
        this.location =location;
//        soldOutState=new SoldOutState(this);
        noQuarterState=new NoQuarterState(this);
//        hasQuarterState=new HasQuarterState(this);
        if (count>0){
            state=noQuarterState;
        }
    }


    public int getCount() {
        return count;
    }

    @Override
    public int getLocation() throws RemoteException {
        return 0;
    }


    public State getWinnerState() {
        return winnerState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
