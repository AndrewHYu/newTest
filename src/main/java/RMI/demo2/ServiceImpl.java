package RMI.demo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Andrew  on 2017/4/21.
 */
public class ServiceImpl extends UnicastRemoteObject implements Service {
    private String name;

    /**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，
     * 因此这里默认的构造方法必须写，必须声明抛出RemoteException异常
     * @param name
     * @throws RemoteException
     */
    public ServiceImpl(String name)throws RemoteException {
        this.name = name;
    }

    @Override
    public String service(String content) {
        return "server >> " + content;
    }
}
