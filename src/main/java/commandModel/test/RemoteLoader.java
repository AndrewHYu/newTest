package commandModel.test;

import commandModel.commandImpl.*;
import commandModel.controler.RemoteControl;
import commandModel.equipment.CeilingFan;
import commandModel.equipment.GarageDoor;
import commandModel.equipment.Light;
import commandModel.equipment.Stereo;

import javax.swing.*;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl=new RemoteControl();

        Light livingRoomLight=new Light("Living Room");
        Light kitchenLight=new Light("Kitchen");
        CeilingFan ceilingFan=new CeilingFan("Living Room");
        GarageDoor garageDoor=new GarageDoor();
        Stereo stereo=new Stereo("Living Room");

        LightOnCommand livingRoomLightOn=new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff=new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn=new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff=new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOnCommand=new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand=new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpenCommand=new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorCloseCommand=new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCDCommand=new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand=new StereoOffCommand(stereo);

        remoteControl.setCommand(0,livingRoomLightOn,livingRoomLightOff);
        remoteControl.setCommand(1,kitchenLightOn,kitchenLightOff);
        remoteControl.setCommand(2,ceilingFanOnCommand,ceilingFanOffCommand);
        remoteControl.setCommand(3,stereoOnWithCDCommand,stereoOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);

    }
}
