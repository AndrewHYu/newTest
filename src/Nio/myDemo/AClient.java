package Nio.myDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Andrew  on 2017/3/2.
 */
public class AClient {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2000);
        SocketChannel socketChannel=SocketChannel.open();
        Selector selector=Selector.open();
        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress("localhost",8080));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            int num = selector.select();

            Set selectKey = selector.selectedKeys();
            Iterator it = selectKey.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) it.next();
                if (selectionKey.isConnectable()) {
//                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                    socketChannel.register(selector, SelectionKey.OP_READ);

//                    if (socketChannel.isConnectionPending()) {
                        if (socketChannel.finishConnect()) {
                            // 只有当连接成功后才能注册OP_READ事件
//                            selectionKey.interestOps(SelectionKey.OP_READ);
                            byteBuffer.put("123456789abcdefghijklmnopq".getBytes());
                            byteBuffer.flip();
                            System.out.println("##" + new String(byteBuffer.array()));
                            socketChannel.write(byteBuffer);
                            System.out.println("写入完毕");
                        } else {
                            socketChannel.close();
                        }
//                    }
                } else if (selectionKey.isReadable()){
                    while (true){
                        byteBuffer.clear();
                        int r=socketChannel.read(byteBuffer);
                        if (r<=0){
                            System.out.println("接收完毕，断开连接");
                            socketChannel.close();
                            break;
                        }
                        System.out.println("##" + r + " " + new String(byteBuffer.array(), 0, byteBuffer.position()));
                        byteBuffer.flip();
                    }
                }
            }
        }
    }
}
