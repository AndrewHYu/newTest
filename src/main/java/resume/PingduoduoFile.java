package resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 10
 my-app -1
 scr 0
 main 1
 java 2
 resource 2
 webapp 2
 test 1
 java 6
 resource 6
 pom.xm 0
 *
 *
 * @author huangyu
 * @date 2017/9/2
 */
public class PingduoduoFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();

        int n = Integer.valueOf(ss);
        int[] b = new int[n];

        List<Path> list = new ArrayList<>(n);
        for (int i = 0;i < n;i++){
            ss = in.nextLine();
            String[] sss = ss.split(" ");
            Path p = new Path();
            p.name = sss[0];
            p.num = Integer.valueOf(sss[1]);

            b[p.num + 1]++;
            p.count = b[p.num + 1];

            list.add(p);
        }
        for (int i = 0;i < n;i++) {
            Path p = list.get(i);
            String name = "";
            int num = p.num;
            int count = p.count;
            if (num < 0)
                System.out.println(p.name);
            else{

            }

        }


    }
    static class Path{
        String name;
        int num;
        int count;
    }
}
