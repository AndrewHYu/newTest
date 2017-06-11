package zookeeper.demo2;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2017/6/11.
 */
public class AppClient {
    private  volatile List<String> servers;
    private ZooKeeper zk;
    //使用zk的监听器功能触发服务器更新的动作
    public void connectZK() throws IOException, KeeperException, InterruptedException{


        zk = new ZooKeeper("192.168.56.102:2181,192.168.56.103:2181,192.168.56.104:2181", 5000, new Watcher() {

            //监听事件发生时的回调方法
            @Override
            public void process(WatchedEvent event) {

                if("/grpnode".equals(event.getPath()) && event.getType()== Event.EventType.NodeChildrenChanged ){
                    //触发更新服务器列表的动作
                    try {
                        updateServerList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        updateServerList();

    }

    //动态获取服务器列表
    public void updateServerList() throws KeeperException, InterruptedException, UnsupportedEncodingException {
        ArrayList<String> serverList=new ArrayList<String>();


        //监听子节点,并且对父节点注册监听器
        List<String>  childer=zk.getChildren("/grpnode", true);

        //遍历子节点
        for(String child:childer){
            byte[] data=zk.getData("/grpnode/"+child,false, new Stat());
            String server=new String(data,"utf-8");
            //将获取到的服务器名称存入list
            serverList.add(server);
        }
        //把暂存的list放到全局的list中
        servers=serverList;
        System.out.println("最新的在线服务器是:"+serverList);
    }

    //客户端的业务功能
    public void handle() throws InterruptedException{

        Thread.sleep(30);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException{

        AppClient client=new AppClient();
        client.connectZK();
        client.handle();

    }
}
