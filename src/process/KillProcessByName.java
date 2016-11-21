package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrew  on 2016/11/21.
 */
public class KillProcessByName {
    public static void main(String[] args) {
        try {
            String processName="QQ.exe";

            //taskkill /f /fi "IMAGENAME eq QvodTerminal.exe"
            Process process=Runtime.getRuntime().exec("tasklist /fi \"imagename eq qq.exe\"");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s=bufferedReader.readLine())!=null) {
                if(s.indexOf(processName)>=0) {
                    System.out.println(s);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
