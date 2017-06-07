package complex.DJ.contraller.contrallerImpl;

import complex.DJ.contraller.ControllerInterface;
import complex.DJ.modelService.HeartModelInterface;
import complex.DJ.view.DJView;
import complex.DJ.view.HeartAdapter;

/**
 * Created by Andrew  on 2016/10/16.
 */
public class HeartController implements ControllerInterface {
    HeartModelInterface model;
    DJView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    public void start() {}
    public void stop() {}

    public void increaseBPM() {}

    public void decreaseBPM() {}

    public void setBPM(int bpm) {}
}
