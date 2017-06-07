package commandModel.equipment;

/**
 * Created by Andrew  on 2016/9/21.
 */
public class CeilingFan {
    String location;
    public CeilingFan(){

    }
    public CeilingFan(String location){
        this.location=location;
    }
    public void on(){
        System.out.println("The "+location+"Ceiling Fan turn on");
    }
    public void off(){
        System.out.println("The "+location+" Ceiling Fan turn off");
    }
}
