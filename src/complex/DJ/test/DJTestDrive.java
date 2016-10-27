package complex.DJ.test;

import complex.DJ.contraller.ControllerInterface;
import complex.DJ.contraller.contrallerImpl.BeatController;
import complex.DJ.modelService.BeatModelInterface;
import complex.DJ.modelService.ModelImpl.BeatModel;

/**
 * Created by Andrew  on 2016/10/16.
 */
public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model=new BeatModel();
        ControllerInterface contraller=new BeatController(model);
    }
}
