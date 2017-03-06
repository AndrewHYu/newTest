package Nio.myDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Andrew  on 2017/3/2.
 */
public class AServer {
    private int port[];
    private ByteBuffer byteBuffer=ByteBuffer.allocate(5);

    public AServer(int[] port) throws IOException {
        this.port = port;
        start();
    }
    private void start() throws IOException {
        Selector selector=Selector.open();
        for (int i=0;i<port.length;i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            InetSocketAddress inetSocketAddress=new InetSocketAddress(port[i]);
            serverSocketChannel.bind(inetSocketAddress);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Already for get access ");
        }
        while (true){
            int m=selector.select();
            Set selectedKeys=selector.selectedKeys();
            Iterator it=selectedKeys.iterator();
            while (it.hasNext()){
                SelectionKey selectionKey=(SelectionKey) it.next();
                if (selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel=(ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()){
                    SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                    while (true){
                        byteBuffer.clear();
                        int r=socketChannel.read(byteBuffer);
                        if (r<=0){
                            System.out.println("接收完毕，准备回复");
                            socketChannel.write(ByteBuffer.wrap("你好".getBytes()));
                            socketChannel.close();
                            break;
                        }
                        System.out.println("##" + r + " " + new String(byteBuffer.array(), 0, byteBuffer.position()));
                        byteBuffer.flip();

                    }

                }else {
                    SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                    socketChannel.close();
                }
                it.remove();
            }
        }
    }
}
