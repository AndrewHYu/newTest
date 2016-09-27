package commandModel.equipment;

/**
 * Created by Andrew  on 2016/9/20.
 */
public class Light {
    String location;
    public Light(){

    }
    public Light(String location){
        this.location=location;
    }
    public void on(){
        System.out.println("The "+location+"light turn on");
    }
    public void off(){
        System.out.println("The "+location+" light turn off");
    }
}
