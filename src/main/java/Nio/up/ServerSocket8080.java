package Nio.up;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by Andrew  on 2017/3/2.
 */
public class ServerSocket8080 {
    public ServerSocket8080(int port) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
//        Selector selector = Selector.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ss.bind(address);
        SelectionKey key = ssc.register(SelectorTool.getSelectorTool().getSelector(), SelectionKey.OP_ACCEPT);
        System.out.println("开始监听……");

    }


}
