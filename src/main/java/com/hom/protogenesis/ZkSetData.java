package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkSetData {

    public static void setData(ZooKeeper zooKeeper, String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.setData(path, data, ZkExists.zkNodeExists(zooKeeper,path).getVersion());
    }
}
