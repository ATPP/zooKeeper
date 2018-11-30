package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkExists {

    public static Stat zkNodeExists(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }
}
