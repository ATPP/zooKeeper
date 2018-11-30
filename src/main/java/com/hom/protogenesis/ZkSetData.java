package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkSetData {

    /**
     * path- Znode路径
     * data - 要存储在指定znode路径中的数据。
     * version- znode的当前版本。每当数据更改时，ZooKeeper会更新znode的版本号。
     *
     * @param zooKeeper
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void setData(ZooKeeper zooKeeper, String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.setData(path, data, ZkExists.zkNodeExists(zooKeeper, path).getVersion());
    }
}
