package ModelModel.fifth;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class MyApplet extends Applet {
    String msg;
    public void init(){
        msg="Hello World ,I'm alive";
        repaint();
    }
    public void start(){
        msg="Now I'm starting up";
        repaint();
    }
    public void stop(){
        msg="Oh ,now I'm being stopped";
        repaint();
    }
    public void destroy(){
        System.out.println("Destroy");
    }
    public void paint(Graphics graphics){
        graphics.drawString(msg,5,15);
    }
}
