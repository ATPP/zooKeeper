package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZkDelete {

    /**
     * path - Znode路径。
     * version - znode的当前版本。
     *
     * @param zooKeeper
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void delete(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path, ZkExists.zkNodeExists(zooKeeper, path).getVersion());
    }
}
