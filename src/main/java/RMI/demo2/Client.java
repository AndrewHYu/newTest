package RMI.demo2;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Andrew  on 2017/4/21.
 */
public class Client {
    public static void main(String[] args) throws NamingException, RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1",4545);
        String[] list = registry.list();
        for(String s : list){
            System.out.println(s);
        }
        Service service = (Service)registry.lookup("service/01");
        Class serviceClass = service.getClass();
        Class[] interfaces = serviceClass.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println("存根类实现了 " + c.getName() + " 接口！");
            System.out.println(service.service("你好！"));
        }
    }
}
