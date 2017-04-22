package RMI.demo1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Andrew  on 2017/4/21.
 */
public class Server {
    public static void main(String[] args) throws NamingException, RemoteException {
        Service service = new ServiceImpl("service01");
        Context context = new InitialContext();
        //本地主机上的远程对象注册表Registry的实例，并指定端口为8888
        LocateRegistry.createRegistry(4545);
        context.rebind("rmi://localhost:4545/service/01",service);
        System.out.println("服务器向命名表注册了1个远程服务对象！");
    }
}
