package resume;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 6553,1-655,5-1010,1011,1012
 * @author huangyu
 * @date 2017/9/21
 */
public class ShenXingfu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(",");
        Port[] ports = new Port[100];
        int n = 0;
        for (int i = 0,j = 0;i < ss.length;i++){
            int index = ss[i].indexOf("-");
            if (index > 0){
                n +=2;
                String[] sss = ss[i].split("-");
                Port p1 = new Port();
                p1.a = Integer.valueOf(sss[0]);
                p1.b = 1;
                ports[j++] = p1;

                Port p2 = new Port();
                p2.a = Integer.valueOf(sss[1]);
                p2.b = 2;
                ports[j++] = p2;
            }else {
                Port p1 = new Port();
                p1.a = Integer.valueOf(ss[i]);
                ports[j++] = p1;
                n++;
            }
        }
        Arrays.sort(ports, new Comparator<Port>() {
            @Override
            public int compare(Port o1, Port o2) {
                if (o1 == null)
                    return 1;
                if (o2 == null)
                    return -1;
                if (o1.a > o2.a)
                    return 1;
                else if (o1.a < o2.a)
                    return -1;
                return 0;
            }
        });

        Deque<String> portQueue = new ArrayDeque<>(n);
        portQueue.add(ports[0].a + "");
        if (ports[0].b == 1)
            portQueue.add("-");
        for (int i = 1;i < n;i++){
            String tem = portQueue.peekLast();
            if (tem.equals("-") && ports[i].b == 2)
                portQueue.add(ports[i].a + "");
            else if (!tem.equals("-")){
                Integer a = Integer.valueOf(portQueue.peekLast());
                if ((a + 1) == ports[i].a && portQueue.size() > 1){
                    String tt = portQueue.pollLast();
                    if (!portQueue.peekLast().equals("-")){
                        portQueue.addLast(tt);
                        portQueue.add("-");
                    }
                }
                portQueue.add(ports[i].a + "");
            }


        }
    }
    static class Port{
        int a = 0 ;
        int b = 0;
    }

    public void test1(){
         /*     Scanner in = new Scanner(System.in);
        String s = in.nextLine();*/
        String s="http://www.sangfor.com:8080/";
        StringBuilder sb = new StringBuilder();
        int a = s.indexOf("//");
        int b = s.lastIndexOf(":");
        int c = s.lastIndexOf("/");
        try {
            System.out.println(sb.append(s.substring(a+2,b)).append(",").append(s.substring(b + 1,c)).toString());
        }catch (Exception e){
            System.out.println(-1);
        }
    }
}
