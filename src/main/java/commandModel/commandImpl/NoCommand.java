package commandModel.commandImpl;

import commandModel.command.Command;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class NoCommand implements Command {
    Command command;
    public NoCommand(){
    }
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
