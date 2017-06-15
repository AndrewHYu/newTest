package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew  on 2017/6/11.
 */
public class ConnectionTest {
    ZooKeeper zk=null;

    @Before
    public void init() throws IOException {
        zk = new ZooKeeper("192.168.56.102:2181,192.168.56.103:2181,192.168.56.104:2181",5000,new Watcher(){

            public void process(WatchedEvent event) {
                System.out.println(event.getPath());
                System.out.println(event.getType());
            }
        });
    }

    @Test
    public void testZkNode() throws Exception {
        TimeUnit.SECONDS.sleep(5);

        String path = zk.create("/eclipse", "Andrew".getBytes("utf-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("创建了一个永久节点： " + path);
        zk.close();

    }

    @Test
    public void testGet() throws Exception {
        TimeUnit.SECONDS.sleep(5);

        //监听器的注册只能生效一次
        byte[] data = zk.getData("/eclipse", true, new Stat());
        System.out.println(new String(data,"utf-8"));
//        Thread.sleep(Long.MAX_VALUE);

    }

    @Test
    public void testSet() throws UnsupportedEncodingException, KeeperException, InterruptedException{

        TimeUnit.SECONDS.sleep(5);

        zk.setData("/eclipse", "谁是英雄".getBytes("utf-8"), -1);
        zk.close();

    }

    @Test
    public void testDelete() throws UnsupportedEncodingException, KeeperException, InterruptedException{

        TimeUnit.SECONDS.sleep(5);

        zk.delete("/eclipse",  -1);
        zk.close();

    }
}
