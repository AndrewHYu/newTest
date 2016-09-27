package commandModel.equipment;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class Stereo {
    int volume;
    String location;
    public Stereo(){

    }
    public Stereo(String location){
        this.location=location;
    }
    public void on(){
        System.out.println("The "+location+" Stereo turn on");
    }
    public void off(){
        System.out.println("The "+location+" Stereo turn off");
    }
    public void setCd(){
        System.out.println("The "+location+" Stereo setCd");
    }
    public void setDvd(){
        System.out.println("The "+location+" Stereo setDvd");
    }
    public void setRadio(){
        System.out.println("The "+location+" Stereo setRadio");
    }
    public void setVolume(int volume){
        this.volume=volume;
        System.out.println("The "+location+" Stereo setVolume and the volume is "+volume);
    }


}
