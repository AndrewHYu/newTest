package netcap;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import static netcap.Util.toByte;
import static netcap.Util.toByteArray;

/**
 * @author Andrew
 * @date 2017/11/5
 */
public class SimulationPPPOE {

//    Logger logger = LoggerFactory.getLogger(SimulationPPPOE.class);
    private NetworkInterface[] devices; //设备列表
    private NetworkInterface device; //要使用的设备
    private JpcapCaptor jpcap; //与设备的连接
    private JpcapSender sender; //用于发送的实例
   /* private byte[] targetMAC, gateMAC; //B的MAC地址，网关的MAC地址
    private String targetIp, gateIp; //B的IP地址，网关的IP地址*/

    public SimulationPPPOE() {
        devices = JpcapCaptor.getDeviceList();
        // TODO: 2017/11/5 暂时写死
        device = devices[3];
        try {
            jpcap = JpcapCaptor.openDevice(device,65535,false,200);
        } catch (IOException e) {
            System.out.println("can't open the Device");
//            logger.error("can't open the Device");
        }
        sender = jpcap.getJpcapSenderInstance();
    }

    /**
     * 客户端到服务器：Initiation（PADI）
     */
    public Packet PADI(String macSrc, String ipSrc, String macDst, String ipDst) throws UnknownHostException {
        IPPacket packet = new IPPacket();
        packet.dst_ip = InetAddress.getByName(ipSrc);
        packet.src_ip = InetAddress.getByName(ipDst);

        EthernetPacket thPacket = new EthernetPacket();
        thPacket.dst_mac = toByte(macDst);
        thPacket.src_mac = toByte(macSrc);

        packet.datalink = thPacket;
        packet.version = 1;
        String[] intHeader = {"88","63","11","7","0","0"};
        byte[] header = toByteArray(intHeader);
        packet.header = header;

        return packet;
    }

    /**
     * 服务器到客户端：Offer (PADO)
     */
    public void PADO(){

    }

    /**
     * 客户端到服务器：Request（PADR）
     */
    public void PADR(){

    }

    /**
     * 服务器到客户端：Session-confirmation（PADS）
     */
    public void PADS(){

    }

    /**
     * 任何一方：Termination（PADT）
     */
    public void PADT(){

    }
    public void send(Packet packet){
        sender.sendPacket(packet);
    }

    public static void main(String[] args) throws UnknownHostException {
/*        SimulationPPPOE ppoe = new SimulationPPPOE();
        Packet packet = ppoe.PADI("74-5a-aa-c0-da-f3","192.168.1.1","28-d2-44-0c-65-db","192.168.1.101");
        ppoe.send(packet);*/

        Packet packet = new Packet();
        String[] intHeader = {"","88","63","11","7","0","0"};
    }
}
