package commandModel.commandImpl;

import commandModel.command.Command;
import commandModel.equipment.Stereo;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class StereoOnWithCDCommand implements Command{
    Stereo stereo;
    public StereoOnWithCDCommand(Stereo stereo){
        this.stereo=stereo;
    }
    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {

    }
}
