package netcap;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.ARPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyu
 * @date 2017/10/29
 */
public class Netcaptor {

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        /*--------------    第一步绑定网络设备       --------------*/
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        //for each network interface
        for (int i = 0; i < devices.length; i++) {
            //print out its name and description
            System.out.println(i+": "+devices[i].name + "(" + devices[i].description+")");

            //print out its datalink name and description
            System.out.println(" datalink: "+devices[i].datalink_name + "(" + devices[i].datalink_description+")");

            //print out its MAC address
            System.out.print(" MAC address:");
            for (byte b : devices[i].mac_address)
                System.out.print(Integer.toHexString(b&0xff) + ":");
            System.out.println();

            //print out its IP address, subnet mask and broadcast address
            for (NetworkInterfaceAddress a : devices[i].addresses)
                System.out.println(" address:"+a.address + " " + a.subnet + " "+ a.broadcast);
        }
      /*  for(NetworkInterface n : devices)
        {
            System.out.println(n.name + "     |     " + n.description);
            System.out.println(n.datalink_description+"      |      "+n.datalink_name);
            for (byte b : n.mac_address)
                System.out.print(Integer.toHexString(b&0xff) + ":");
            System.out.println();
        }*/
        System.out.println("-------------------------------------------");

        JpcapCaptor jpcap = null;
        int caplen = 1512;
        boolean promiscCheck = false;

        try{
            jpcap = JpcapCaptor.openDevice(devices[3], 65535, false, 20);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

/*        jpcap.processPacket(1,new PacketPrinter());
        TimeUnit.SECONDS.sleep(20);
        jpcap.close();*/
        /*----------第二步抓包-----------------*/
        try {
            jpcap.setFilter("tcp [0x13:2] == 0xc023",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i < 50;)
        {
            Packet packet  = jpcap.getPacket();

            if(packet != null)
            {
                i++;
                if (packet instanceof IPPacket){
                    System.out.println("================="+i+"+++++++++++++++");
                    IPPacket ip = (IPPacket)packet;//强转

                    System.out.println("版本：IPv4");
                    System.out.println("优先权：" + ip.priority);
                    System.out.println("区分服务：最大的吞吐量： " + ip.t_flag);
                    System.out.println("区分服务：最高的可靠性：" + ip.r_flag);
                    System.out.println("长度：" + ip.length);
                    System.out.println("标识：" + ip.ident);
                    System.out.println("DF:Don't Fragment: " + ip.dont_frag);
                    System.out.println("NF:Nore Fragment: " + ip.more_frag);
                    System.out.println("片偏移：" + ip.offset);
                    System.out.println("生存时间："+ ip.hop_limit);
                    System.out.println("data:" + new String(ip.data, Charset.forName("ASCII")));

                    String protocol ="";
                    switch(ip.protocol)
                    {
                        case 1:protocol = "ICMP";break;
                        case 2:protocol = "IGMP";break;
                        case 6:protocol = "TCP";break;
                        case 8:protocol = "EGP";break;
                        case 9:protocol = "IGP";break;
                        case 17:protocol = "UDP";break;
                        case 41:protocol = "IPv6";break;
                        case 89:protocol = "OSPF";break;
                        default : break;
                    }
                    System.out.println("协议：" + protocol);
                    System.out.println("源IP " + ip.src_ip.getHostAddress());
                    System.out.println("目的IP " + ip.dst_ip.getHostAddress());
                    System.out.println("源主机名： " + ip.src_ip);
                    System.out.println("目的主机名： " + ip.dst_ip);
                    System.out.println("----------------------------------------------");
                }else if (packet instanceof ARPPacket){
                    System.out.println("================="+i+"+++++++++++++++");
                    ARPPacket arpPacket = (ARPPacket)packet;//强转
                    System.out.println(arpPacket.toString());
                }else {
                    System.out.println("get a another packet:"+packet.toString());
                }

            }
        }



    }
}
