package zookeeper.demo2;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by Andrew  on 2017/6/11.
 */
public class AppServer {
    private ZooKeeper zk;
    private String groupNode = "grpnode";
    private String subNode = "sub";

    // 向zookeeper注册信息
    public void connectZK(String name) throws KeeperException, InterruptedException, IOException {
        zk = new ZooKeeper("192.168.56.102:2181,192.168.56.103:2181,192.168.56.104:2181", 5000, new Watcher() {

            //监听事件发生时的回调方法
            @Override
            public void process(WatchedEvent event) {
                System.out.println("get Connection");
            }
        });
        Thread.sleep(5);
        String path = zk.create("/" + groupNode + "/" + subNode, name.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("服务器上线，创建了一个子节点： " + path);

    }

    // 业务处理逻辑
    public void handle() throws Exception {

        Thread.sleep(30);

    }

    public static void main(String[] args) throws Exception {

        if(args.length==0){
/*            System.err.println("参数个数不对，请附加服务器名作为参数来启动.....");
            System.exit(1);*/
        }
        // 去向zookeeper注册本服务器信息
        AppServer server = new AppServer();
        server.connectZK("andrew");
        server.handle();

    }
}
