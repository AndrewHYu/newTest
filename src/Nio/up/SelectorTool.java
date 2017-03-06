package Nio.up;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Andrew  on 2017/3/1.
 */
public class SelectorTool {
    private Selector selector = Selector.open();
    private volatile static SelectorTool selectorTool=null;
    private ByteBuffer echoBuffer = ByteBuffer.allocate(8);

    public SelectorTool() throws IOException {
    }

    public Selector getSelector() {
        return selector;
    }

    public static SelectorTool getSelectorTool() {
        if (selectorTool==null) {
            synchronized (SelectorTool.class) {
                if (selectorTool==null) {
                    try {
                        selectorTool = new SelectorTool();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return selectorTool;
    }

    public void read() throws IOException {
        while (true) {
            int num = selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey sKey = (SelectionKey) it.next();
                SocketChannel channel = null;
                if (sKey.isAcceptable()) {
                    ServerSocketChannel sc = (ServerSocketChannel) sKey.channel();
                    System.out.println("准备接收信息");
                    System.out.println("++++++++++++++++++++++++++++++++");
                    channel = sc.accept();// 接受连接请求
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    it.remove();
                } else if (sKey.isReadable()) {
                    channel = (SocketChannel) sKey.channel();
                    while (true) {
                        echoBuffer.clear();
                        int r = channel.read(echoBuffer);
                        if (r <= 0) {
                            System.out.println("接收完毕，断开连接");
                            channel.close();
                            break;
                        }
                        System.out.println("##" + r + " " + new String(echoBuffer.array(), 0, echoBuffer.position()));
                        echoBuffer.flip();
                    }
                    it.remove();
                } else {
                    channel.close();
                }
            }
        }
    }
}
