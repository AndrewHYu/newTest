package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerSocketChannelTest {

	public static void main(String[] args) throws IOException {
		
		ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(999));
		ByteBuffer buffer=ByteBuffer.allocate(10);
		
		DatagramChannel datagramChannel=DatagramChannel.open();
		datagramChannel.socket().bind(new InetSocketAddress(998));
		
		Pipe pipe=Pipe.open();
		//serverSocketChannel.configureBlocking(false);
		while (true) {
			SocketChannel socketChannel=serverSocketChannel.accept();
			int n=0;
			do{
				buffer.clear();
				datagramChannel.receive(buffer);
				System.out.println("dg:"+new String(buffer.array(),"utf-8"));
				buffer.clear();
				n=socketChannel.read(buffer);
				//System.out.println(buffer.getChar());
				System.out.println("sc:"+new String(buffer.array(),"utf-8"));
				String string=new String (Charset.forName("utf-8").newDecoder().decode(buffer).array());
				System.out.println("scnew:"+string);
				buffer.clear();
				
//				Pipe.SourceChannel sourceChannel=pipe.source();
//				sourceChannel.read(buffer);
//				System.out.println("sinkChannel"+new String(buffer.array(),"utf-8"));
//				sourceChannel.close();
				
			}while(n==10);
			
			socketChannel.close();
		}
		

	}

}
