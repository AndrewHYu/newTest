package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.Light;

/**
 * Created by Andrew  on 2016/9/20.
 */
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
