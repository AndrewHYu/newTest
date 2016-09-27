package commandModel.test;

import commandModel.commandImpl.GarageDoorOpenCommand;
import commandModel.commandImpl.LightOnCommand;
import commandModel.controler.SimpleRemoteControl;
import commandModel.equipment.GarageDoor;
import commandModel.equipment.Light;

/**
 * Created by Andrew  on 2016/9/20.
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl=new SimpleRemoteControl();
        Light light=new Light();
        LightOnCommand lightOnCommand=new LightOnCommand(light);

        GarageDoor garageDoor=new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand=new GarageDoorOpenCommand(garageDoor);

        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();

        simpleRemoteControl.setCommand(garageDoorOpenCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
