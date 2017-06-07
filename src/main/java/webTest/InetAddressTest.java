package webTest;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Admin on 2016/3/30
 * Socket s=new Socket();
 * s.connect(new InetSocketAddress(host,port),timeout).
 * 或者
 * Socket s=new Socket(..);
 * s.setSoTimeout(1000); 1 second
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException
    {
        if (args.length>0)
        {
            String host = args[0];
            InetAddress[] addresses=InetAddress.getAllByName(host);
            for (InetAddress a:addresses)
                System.out.println(a);
        }else
        {
            InetAddress localhostAddress=InetAddress.getLocalHost();
            System.out.println(localhostAddress);
        }
    }
}
