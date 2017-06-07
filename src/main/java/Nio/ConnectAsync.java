package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Andrew  on 2017/3/4.
 */
public class ConnectAsync {
    public static void main(String[] args) throws IOException, InterruptedException {
        String host = "localhost";
        int port = 1234;

        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        System.out.println("initiation connection");
        sc.connect(new InetSocketAddress(host,port));
        while (!sc.finishConnect()){
            Thread.sleep(200);
            System.out.println("doing something useful and waiting for connection finish");
        }
        System.out.println("connection establish");
        sc.write(ByteBuffer.wrap("22".getBytes()));
        sc.close();
    }
}
