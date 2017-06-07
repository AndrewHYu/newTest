package threadPool.TestThreadzhiyuan;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Andrew  on 2016/9/12.
 */
public class Zhiyuan {
    public static void main(String[] args) throws Exception{
    final URL url=new URL("http://www.zycq.cn/");

    for(int i=0;i<200;i++){
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                   try {
                       HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                       if (httpURLConnection.getResponseCode()==200){
                           System.out.println("goood");
                       }
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }
    }
}
