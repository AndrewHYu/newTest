package complex.DJ.test;

import complex.DJ.contraller.ControllerInterface;
import complex.DJ.contraller.contrallerImpl.HeartController;
import complex.DJ.modelService.HeartModelInterface;
import complex.DJ.modelService.ModelImpl.HeartModel;

/**
 * Created by Andrew  on 2016/10/16.
 */
public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel=new HeartModel();
        ControllerInterface model=new HeartController(heartModel);
    }
}
