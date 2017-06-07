package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.Light;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
