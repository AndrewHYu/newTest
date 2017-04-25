package RMI.demo1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Andrew  on 2017/4/21.
 * 如果一个远程类已经继承了其他类，
 * 无法再继承UnicastRemoteObject类，
 * 那么可以在构造方法中调用UnicastRemoteObject类的静态exportObject()方法，
 * 同样，远程类的构造方法也必须声明抛出RemoteException。
 * UnicastRemoteObject.exportObject(this,0);
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
        System.out.println("server service");
        return "server >> " + content;
    }
}
