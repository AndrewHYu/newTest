package RMI.demo3;

import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Andrew  on 2017/4/21.
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        Service service = (Service) Naming.lookup("rmi://127.0.0.1:4545/service/01");
        Class serviceClass = service.getClass();
        Class[] interfaces = serviceClass.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println("存根类实现了 " + c.getName() + " 接口！");
            System.out.println(service.service("你好！"));
        }
    }
}
