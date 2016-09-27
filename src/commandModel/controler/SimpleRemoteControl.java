package commandModel.controler;

import commandModel.command.Command;

/**
 * Created by Andrew  on 2016/9/20.
 */
public class SimpleRemoteControl {
    Command slot;
    public SimpleRemoteControl(){

    }
    public void setCommand(Command command){
        slot=command;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}
