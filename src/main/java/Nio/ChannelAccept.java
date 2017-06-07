package Nio;

import org.python.netty.buffer.ByteBufAllocator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Andrew  on 2017/3/4.
 */
public class ChannelAccept {
    public static final String GREETING = "Hello I must be going.\r\n";
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(20);
    public static void main(String[] args) throws IOException, InterruptedException {

        int port=1234;

//        ByteBuffer byteBuffer=ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        while (true){
            System.out.println("waiting for connection");
            SocketChannel sc = ssc.accept();
            if (sc==null){
                Thread.sleep(2000);
            }else{
                System.out.println("Income connection from:"+
                sc.socket().getRemoteSocketAddress());
                byteBuffer.limit(1);
                int num = sc.read(byteBuffer);
                if (num>0){
                    System.out.println(byteBuffer.toString());
                    System.out.println(new String(byteBuffer.array()));
                }

                byteBuffer.flip();
                sc.write(byteBuffer);
                byteBuffer.clear();
                sc.close();
            }
        }
    }
}
