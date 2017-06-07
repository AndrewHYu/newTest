package Nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;

public class TestSelector {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file =new File("E:/hh/hello.txt");
		Path path=file.toPath();
		FileChannel fileChannel=FileChannel.open(path,StandardOpenOption.READ);
		//channel.lock(),channel.tryLock(),第一个调用会阻塞直至可获得锁；第二个将立即返回，要么返回锁要么在锁不可获得的情况返回null;
		FileLock lock=fileChannel.lock();
		FileInputStream reader = new FileInputStream(file);
		FileChannel channel=reader.getChannel();
		
		Selector selector=Selector.open();
		
		SocketChannel socketChannel=SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 999));
		
		//如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来
		SelectionKey key=socketChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		
		int interestSet = key.interestOps();  
		System.out.println(SelectionKey.OP_ACCEPT|SelectionKey.OP_CONNECT);  
		boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT; 
//		boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
//		boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
//		boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE; 
		
		Channel channel2=key.channel();
		Selector selector2 =key.selector();
		Set<SelectionKey> selectedKeys=selector2.selectedKeys();
		//Set selectedKeys = selector.selectedKeys();  
		Iterator keyIterator = selectedKeys.iterator();  
		while(keyIterator.hasNext()) {  
		    SelectionKey key1 =(SelectionKey)keyIterator.next();  
		    if(key1.isAcceptable()) {  
		        // a connection was accepted by a ServerSocketChannel.  
		    } else if (key.isConnectable()) {  
		        // a connection was established with a remote server.  
		    } else if (key.isReadable()) {  
		        // a channel is ready for reading  
		    } else if (key.isWritable()) {  
		        // a channel is ready for writing  
		    }  
		     
		}
		
		ByteBuffer buffer=ByteBuffer.allocate(20);
		
		DatagramChannel datagramChannel=DatagramChannel.open();
		
		Pipe pipe=Pipe.open();
		SinkChannel sinkChannel=pipe.sink();
		//socketChannel.finishConnect();//判断连接是否完成，只在非阻塞情况下意义较大
		buffer.clear();
		if(socketChannel.finishConnect()){
			int n=0;
			do{
				buffer.clear();
				n=channel.read(buffer);
				buffer.flip();
				datagramChannel.send(buffer,new InetSocketAddress("127.0.0.1", 998));
				System.out.println(new String(buffer.array(),"utf-8"));
				buffer.flip();
				while(buffer.hasRemaining()){
					socketChannel.write(buffer);
					sinkChannel.write(buffer);
					System.out.println(buffer.position());
					}
				buffer.clear();
				//socketChannel.write(buffer);
				
			}while(n==20);
			sinkChannel.close();
			
			Pipe.SourceChannel sourceChannel=pipe.source();
			sourceChannel.read(buffer);
			System.out.println("sinkChannel"+new String(buffer.array(),"utf-8"));
			sourceChannel.close();
		}
		datagramChannel.close();
		socketChannel.close();
		channel.close();
	}

}
