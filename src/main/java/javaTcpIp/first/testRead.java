package javaTcpIp.first;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Andrew  on 2016/11/5.
 */
public class testRead {
    public static void main(String[] args) {
        byte[] buff=new byte[1024];
        while (true){
            try {
                Socket socket=new Socket("",999);
                ServerSocket serverSocket=new ServerSocket(000);
                int n=System.in.read(buff);
                System.out.println(n);
                System.out.println(buff);
                System.out.println("buff.length"+buff.length);
                char[] ch=new String (buff).toCharArray();
                System.out.println("ch.length"+ch.length);
                for (char c:
                     ch) {
                    System.out.println("c"+c);
                }
                System.out.write(buff,0,n);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
