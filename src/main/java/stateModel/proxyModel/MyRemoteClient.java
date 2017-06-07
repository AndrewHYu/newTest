package stateModel.proxyModel;

import java.rmi.Naming;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class MyRemoteClient {
    public void go(){
        try{
            MyRemote service=(MyRemote) Naming.lookup("rmi:127.0.0.1:8808/RemoteHello");
            String s=service.sayHello();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
