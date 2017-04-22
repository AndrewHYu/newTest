package RMI.demo1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Andrew  on 2017/4/21.
 */
public class Client {
    public static void main(String[] args) throws NamingException, RemoteException {
        String url ="rmi://127.0.0.1:4545/";
        Context context = new InitialContext();
        Service service = (Service)context.lookup(url+"service/01");
        Class serviceClass = service.getClass();
        Class[] interfaces = serviceClass.getInterfaces();
        for (Class c :
                interfaces) {
            System.out.println("存根类实现了 " + c.getName() + " 接口！");
            System.out.println(service.service("你好！"));
        }
    }
}
