package XATest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Andrew  on 2016/8/29.
 */
public class FindInfo {
    public static void main(String []args) throws Exception{
        int flag=0;
        String result="";
        String urlString;
        for (int i=0;i<=9999;i++){
            if (flag==0) {
                urlString = "http://hq.sinajs.cn/list=sh60" + String.format("%4d", i).replace(" ", "0");
            }else if (flag==2){
                urlString = "http://hq.sinajs.cn/list=sz00" + String.format("%4d", i).replace(" ", "0");
            }else {
                break;
            }

            if (i==9999)
                flag++;
            String resultTem=get(urlString);
            System.out.println(resultTem);
            if (resultTem!=null){
                result+=urlString.substring(urlString.lastIndexOf("=")+1)+"="+resultTem+"\r\n";
            }
        }
//        File file=new File("C:\\Users\\27032\\Desktop\\1.txt");
//        if (!file.exists())
//            file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\27032\\Desktop\\1.txt");
        fileOutputStream.write(result.getBytes());
        System.out.println(result);


    }
    public static String  get(String urlString)throws Exception{
        String result="";
        URL url=new URL(urlString);
        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        if (httpURLConnection.getResponseCode()==200){
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"GBK"));
            String tempLine;
            while ((tempLine = bufferedReader.readLine())!= null) {
//                System.out.println(tempLine);
                try {
//                    System.out.println(tempLine.substring(tempLine.indexOf("\"") + 1, tempLine.indexOf(",")));
                    result=tempLine.substring(tempLine.indexOf("\"") + 1, tempLine.indexOf(","));
                }catch (StringIndexOutOfBoundsException e){
                    result =null;
                }
            }
            bufferedReader.close();
        }
                return result;
    }
}
