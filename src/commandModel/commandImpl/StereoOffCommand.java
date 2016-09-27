package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.Stereo;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class StereoOffCommand implements Command {
    Stereo stereo;
    public StereoOffCommand(Stereo stereo){
        this.stereo=stereo;
    }
    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
