package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrew  on 2016/11/21.
 */
public class ProcessListTest {
    public static void main(String[] args) throws IOException {
        System.out.println(ProcessListTest.isRunning("QQ.exe"));
    }

    /**
     *
     * @方法名 ：isRunning<br>
     * @方法描述 ：判断系统进程是否存在<br>
     * @创建者 ：Andy.wang<br>
     * @创建时间 ：2014-3-5上午11:25:46 <br>
     * @param exeName ：进程名
     * @return
     * 返回类型 ：boolean
     */
    public static boolean isRunning(String exeName) {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("tasklist");
            BufferedReader br = new BufferedReader(new InputStreamReader(proc
                    .getInputStream()));
            String info = br.readLine();
//            System.out.println("info"+info);
            while (info != null) {
                System.out.println(info);
                if (info.indexOf(exeName) >= 0) {
                    return true;
                }
                info = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(false);
        return false;
    }

}
