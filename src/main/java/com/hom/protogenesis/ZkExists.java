package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkExists {

    /**
     * path- Znode路径
     * watcher - 布尔值，用于指定是否监视指定的znode
     *
     * @param zooKeeper
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static Stat zkNodeExists(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }
}
