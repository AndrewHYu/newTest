package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.CeilingFan;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class CeilingFanOnCommand implements Command {
    CeilingFan ceilingFan;
    public CeilingFanOnCommand(CeilingFan ceilingFan){
        this.ceilingFan=ceilingFan;
    }
    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}
