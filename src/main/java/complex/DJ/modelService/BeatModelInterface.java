package complex.DJ.modelService;

/**
 * Created by Andrew  on 2016/10/16.
 */
public interface BeatModelInterface {
    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver O);
    void removeObserver(BPMObserver o);

}
