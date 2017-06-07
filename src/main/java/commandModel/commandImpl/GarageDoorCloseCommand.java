package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.GarageDoor;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class GarageDoorCloseCommand implements Command{
    GarageDoor garageDoor;
    public GarageDoorCloseCommand(GarageDoor garageDoor){
        this.garageDoor=garageDoor;
    }
    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
