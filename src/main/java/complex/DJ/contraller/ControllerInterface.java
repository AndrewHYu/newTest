package complex.DJ.contraller;

/**
 * Created by Andrew  on 2016/10/16.
 */
public interface ControllerInterface {
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
