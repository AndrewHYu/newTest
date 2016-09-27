package commandModel.command;

/**
 * Created by Andrew  on 2016/9/20.
 */
public interface Command {
    void execute();
    void undo();
}
