package stateModel.second;

import stateModel.second.inter.State;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State state=soldOutState;

    State winnerState;
    int count=0;
    String location;

    public GumballMachine(int count,String location) {
        this.count = count;
        this.location =location;
        soldOutState=new SoldOutState(this);
        noQuarterState=new NoQuarterState(this);
        hasQuarterState=new HasQuarterState(this);
        if (count>0){
            state=noQuarterState;
        }
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
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
