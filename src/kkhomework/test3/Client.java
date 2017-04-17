package kkhomework.test3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
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
        socketChannel.connect(new InetSocketAddress("127.0.0.1",7890));

        String addr = socketChannel.getRemoteAddress().toString();
        String timestamp = new SimpleDateFormat("MMddHHmmSS").format(new Date());

        ClientMessage clientMassge = new ClientMessage(1,"hello");

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
        private int Total_Length;
        private int Command_Id;
        private int Sequence_Id=1;

        private int Msg_Id=001001;
        private int Pk_total=1;
        private int Pk_number=1;//6
        /**
         * 是否要求返回状态确认报告：
         0：不需要；
         1：需要
         */
        private int Registered_Delivery=0;
        private int Msg_level=1;
        private String Service_Id = "aaa22";//9
        private int Fee_UserType=1;
        private String Fee_terminal_Id = "q";
        private int Fee_terminal_type=1;//12
        private int TP_pId=0;
        private int TP_udhi=0;
        private int Msg_Fmt=5;//15
        private String Msg_src = "909090";
        private String FeeType = "01";
        private String FeeCode = "q";//18
        private String ValId_Time = "q";
        private String At_Time = "q";
        private String Src_Id="909090";//21
        private int DestUsr_tl=0;
        private String Dest_terminal_Id = "13912345678";
        private int Dest_terminal_type=0;//24
        private int Msg_Length = 6;
        private String Msg_Content = "";
        private String LinkID = "0123 170410201604 0";//27


        public ClientMessage(int commandId, String content) {
            this.Command_Id = commandId;
            this.Msg_Content = content;
            this.Total_Length = size();
        }
        public int size(){
            return 187+Msg_Content.length();
        }

        @Override
        public String toString() {
            String str = "Total_Length :"+ Total_Length +"\r\n"
                    +"Command_Id :"+ Command_Id +"\r\n"
                    +"Sequence_Id :"+ Sequence_Id + "\r\n" //3
                    +"Msg_Id:"+Msg_Id+"\r\n"
                    +"Pk_total:"+Pk_total+"\r\n"
                    +"Pk_number:"+Pk_number+"\r\n"//6
                    +"Registered_Delivery:"+Registered_Delivery+ "\r\n"
                    +"Msg_level:"+Msg_level+"\r\n"
                    +"Service_Id:"+Service_Id+"\r\n"//9
                    +"Fee_UserType:"+Fee_UserType+"\r\n"
                    +"Fee_terminal_Id:"+Fee_terminal_Id+"\r\n"
                    +"Fee_terminal_type:"+Fee_terminal_type+"\r\n"//12
                    +"TP_pId:"+TP_pId+"\r\n"
                    +"TP_udhi:"+TP_udhi+"\r\n"
                    +"Msg_Fmt:"+Msg_Fmt+"\r\n"//15
                    +"Msg_src:"+Msg_src+"\r\n"
                    +"FeeType:"+FeeType+"\r\n"
                    +"FeeCode:"+FeeCode+"\r\n"//18
                    +"ValId_Time:"+ValId_Time+"\r\n"
                    +"At_Time:"+At_Time+"\r\n"
                    +"Src_Id:"+Src_Id+"\r\n"//21
                    +"DestUsr_tl:"+DestUsr_tl+"\r\n"
                    +"Dest_terminal_Id:"+Dest_terminal_Id+"\r\n"
                    +"Dest_terminal_type:"+Dest_terminal_type+"\r\n"//24
                    +"Msg_Length:"+Msg_Length+"\r\n"
                    +"Msg_Content:"+Msg_Content+"\r\n"
                    +"LinkID:"+LinkID;//27
            return str;
        }
    }

}
