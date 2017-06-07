package stateModel.second;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }
    public void report(){
        System.out.println("Gumball Machine: "+machine.getLocation());
        System.out.println("Current inventory: "+machine.getClass()+" gumballs");
        System.out.println("Current state: "+machine.getState());
    }
}
