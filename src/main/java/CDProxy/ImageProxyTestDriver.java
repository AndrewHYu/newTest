package CDProxy;



import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class ImageProxyTestDriver {
    ImageComponent imageComponent;
    MyFrame frame;
    String initURL="http://tech.gmw.cn/kjcm/attachement/jpg/site2/20150422/c03fd5535f5716a1a02235.jpg";
    public static void main(String[] args) {
        try {
            ImageProxyTestDriver testDriver=new ImageProxyTestDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageProxyTestDriver() throws MalformedURLException {
        Icon icon=new ImageProxy(new URL(initURL));
        imageComponent=new ImageComponent(icon);
        frame=new MyFrame();
        frame.getContentPane().add(imageComponent);
    }
}
