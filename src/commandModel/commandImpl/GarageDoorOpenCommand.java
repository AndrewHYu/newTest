package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.GarageDoor;

/**
 * Created by Andrew  on 2016/9/20.
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor=garageDoor;
    }
    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
