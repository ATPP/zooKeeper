package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class ZkGetChildren {

    /**
     * path - Znode路径。
       watcher - 监视器类型的回调函数。当指定的znode被删除或znode下的子节点被创建/删除时，ZooKeeper集合将进行通知。这是一次性通知。
     * @param zooKeeper
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void getChildren(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        Stat stat = ZkExists.zkNodeExists(zooKeeper, path);
        if (null != stat) {
            List<String> children =  zooKeeper.getChildren(path, false);
            children.forEach(System.out::println);
        }else {
            System.out.println("node not exist");
        }
    }
}
