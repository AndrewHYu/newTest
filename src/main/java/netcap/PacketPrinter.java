package netcap;

import jpcap.PacketReceiver;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

/**
 * @author huangyu
 * @date 2017/11/1
 */
public class PacketPrinter implements PacketReceiver {
    @Override
    public void receivePacket(Packet packet) {
        System.out.println("get a pack+++++++++++++++++");
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
    }
}
