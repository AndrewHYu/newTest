package CDProxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL imageURL;
    Thread retrievalThread;
    boolean retrieving=false;

    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon!=null){
            imageIcon.paintIcon(c,g,x,y);
        }else {
            g.drawString("Loading CD cover, please wait...",x+300,y+190);
            System.out.println("After draw string");
            if (!retrieving){
                retrieving=true;
                retrievalThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        imageIcon=new ImageIcon(imageURL,"CD cover");
                        c.repaint();
                    }
                });
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon!=null){
            return imageIcon.getIconWidth();
        }else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon!=null){
            return imageIcon.getIconHeight();
        }else {
            return 600;
        }
    }
}
