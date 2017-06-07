package Nio.myDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Andrew  on 2017/3/3.
 */
public class AServerTest {
    public static void main(String[] args) throws IOException {
        int [] ports = {8090};
        AServer aServer = new AServer(ports);
       /* SocketChannel socketChannel = SocketChannel.open();
        socketChannel.blockingLock();
        ServerSocket serverSocket = new ServerSocket(2222);
        System.out.println(serverSocket.getChannel());*/
      /*  ByteBuffer byteBuffer = ByteBuffer.allocate (7).order (ByteOrder.BIG_ENDIAN);
        System.out.println(byteBuffer.isDirect());
        CharBuffer charBuffer = byteBuffer.asCharBuffer( ); // Load the ByteBuffer with some bytes
        System.out.println(charBuffer.isDirect());
         byteBuffer.put (0, (byte)'i');
        byteBuffer.put (1, (byte)0);
        byteBuffer.put (2, (byte)0);
        byteBuffer.put (3, (byte)'i');
        byteBuffer.put (4, (byte)0);
        byteBuffer.put (5, (byte)'!');
        byteBuffer.put (6, (byte)0);
        println (byteBuffer);
        println (charBuffer);
    } // Print info about a buffer
     private static void println (Buffer buffer) {
         System.out.println ("pos=" + buffer.position( )
                 + ", limit=" + buffer.limit( )
                 + ", capacity=" + buffer.capacity( )
                 + ": '" + buffer.toString( ) + "'");
                 */
                 }
    }


