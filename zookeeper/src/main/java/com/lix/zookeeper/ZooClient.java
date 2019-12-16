package com.lix.zookeeper;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.List;

public class ZooClient {
    private static String connectString = "zoo-1:2181,zoo-2:2181,zoo-3:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    public void init() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
// 收到事件通知后的回调函数（用户的业务逻辑）
                        System.out.println(event.getType() + "--" +
                                event.getPath());
// 再次启动监听
                        try {
                            zkClient.getChildren("/", true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    // 创建子节点
    @Test
    public void create() throws Exception {
        init();
// 参数 1：要创建的节点的路径； 参数 2：节点数据 ； 参数 3：节点权限 ；参数 4：节点的类型
        String nodeCreated = zkClient.create("/atguigu",
                "jinlian".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(nodeCreated);
    }

    @Test
    public void getChildren() throws Exception {
        init();

        byte[] data = zkClient.getData("/lol", true, new Stat());
        System.out.println(new java.lang.String(data).toString());

        List<String> children = zkClient.getChildren("/",
                true);
        System.out.println(children.size());
        for (String child : children) {
            System.out.println(child);
        }
// 延时阻塞
        Thread.sleep(Long.MAX_VALUE);
    }

    // 判断 znode 是否存在
    @Test
    public void exist() throws Exception {
        Stat stat = zkClient.exists("/eclipse", false);
        System.out.println(stat == null ? "not exist" : "exist");
    }
}
