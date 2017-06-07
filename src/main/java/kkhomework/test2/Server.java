package kkhomework.test2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Andrew  on 2017/3/29.
 */
public class Server {
    private Selector selector;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    private AtomicInteger seq =new AtomicInteger(0);
    private  final String shared_secre ="123546";

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
    public Server() throws IOException {
        try {
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listen();
        select();
    }

    public void listen() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(7890));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    public  void select() throws IOException {
        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            while (selectionKeyIterator.hasNext()){
                SelectionKey selectionKey = selectionKeyIterator.next();
                if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    byteBuffer.clear();
                    String authenticatorSource="";
                    while (socketChannel.read(byteBuffer)>0){
                        if (byteBuffer.position()>0){
                            String string = new String(byteBuffer.array(),0,byteBuffer.position());
                            System.out.println(string);
//                            authenticatorSource=string.substring(string.indexOf("authenticatorSource")+"authenticatorSource".length()+2,string.indexOf("version")-2);
                        }
                        byteBuffer.clear();
                    }
                    seq.getAndIncrement();
                    String resp="";
                    if (authenticatorSource.equals("")){
                        ServerMessage serverMessage = new ServerMessage(seq.get(),0,0,1,0+authenticatorSource+shared_secre,"bye");
                        resp = serverMessage.toString();
                    }else {
                        ServerMessage serverMessage = new ServerMessage(seq.get(),0,0,1,0+authenticatorSource+shared_secre,"bye");
                        resp = serverMessage.toString();
                    }
                    socketChannel.write(ByteBuffer.wrap(resp.getBytes()));
                    socketChannel.close();
                }else if (selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                selectionKeyIterator.remove();
            }

        }

    }
    class ServerMessage {
        private int totalLength;
        private int commandId;
        private int sequenceId=0;

        private int status;
        private String authenticatorISMG;
        private int version;
        private String content;
    public ServerMessage(int sequenceId, int commandId,int status, int version, String authenticatorISMG, String content) {
        this.sequenceId = sequenceId;
        this.commandId = commandId;
        this.status = status;
        this.version = version;
        this.authenticatorISMG = authenticatorISMG;
        this.content = content;
        this.totalLength = size();
    }
    public int size(){
        return 33+content.length();
    }

    @Override
    public String toString() {
        String str = "totalLength :"+totalLength+"\r\n"+"commandId :"+commandId+"\r\n"+"sequenceId :"+sequenceId+
                "\r\n"+"authenticatorISMG:"+authenticatorISMG+"\r\n"+"version:"+version+
                "\r\n"+"status:"+status+"\r\n"+"content:"+content;
        return str;
    }
    }
}
