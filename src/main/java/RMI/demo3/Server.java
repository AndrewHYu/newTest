package RMI.demo3;

import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Andrew  on 2017/4/21.
 */
public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Service service = new ServiceImpl("service01");
        // 创建一个服务注册管理器
        LocateRegistry.createRegistry(4545);
        // 将服务绑定命名
        Naming.rebind("rmi://localhost:4545/service/01",service);
        System.out.println("服务器向命名表注册了1个远程服务对象！");
        while (true){

        }
    }
}
