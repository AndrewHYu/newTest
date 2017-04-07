package kkhomework.test2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew  on 2017\3\29.
 */
public class Client {
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    private  final String shared_secre ="123546";

    public Client() throws IOException, InterruptedException {
        try {
            socketChannel = SocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        send();
        receive();

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
    }
    public void send() throws IOException {
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",4545));

        String addr = socketChannel.getRemoteAddress().toString();
        String timestamp = new SimpleDateFormat("MMddHHmmSS").format(new Date());

        ClientMessage clientMassge = new ClientMessage(1,addr,1,timestamp,addr+shared_secre+timestamp,"hello");

        if (socketChannel.finishConnect()){
            socketChannel.write(ByteBuffer.wrap(clientMassge.toString().getBytes()));
        }
    }
    public void  receive() throws IOException, InterruptedException {
        byteBuffer.clear();
        TimeUnit.SECONDS.sleep(1);
        while (socketChannel.read(byteBuffer)>0){
            System.out.println(new String(byteBuffer.array(),0,byteBuffer.position()));
        }
    }

    class ClientMessage{
        private int totalLength;
        private int commandId;
        private int sequenceId;

        private String sourceAddr;
        private  String authenticatorSource;
        private int version;
        private String timestamp;
        private String content;

        public ClientMessage(int commandId, String sourceAddr, int version, String timestamp, String authenticatorSource, String content) {
            this.commandId = commandId;
            this.sourceAddr = sourceAddr;
            this.version = version;
            this.timestamp = timestamp;
            this.authenticatorSource = authenticatorSource;
            this.content = content;
            this.totalLength = size();
        }
        public int size(){
            return 39+content.length();
        }

        @Override
        public String toString() {
            String str = "totalLength :"+totalLength+"\r\n"+"commandId :"+commandId+"\r\n"+"sequenceId :"+sequenceId+
                    "\r\n"+"sourceAddr:"+sourceAddr+"\r\n"+"authenticatorSource:"+authenticatorSource+"\r\n"+"version:"+version+
                    "\r\n"+"timestamp:"+timestamp+"\r\n"+"content:"+content;
            return str;
        }
    }

}
