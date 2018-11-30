package com.hom.protogenesis;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZkCreate {

    /**
     * path - Znode路径。例如，/myapp1，/myapp2，/myapp1/mydata1，myapp2/mydata1/myanothersubdata
     * data - 要存储在指定znode路径中的数据
     * acl - 要创建的节点的访问控制列表。ZooKeeper API提供了一个静态接口 ZooDefs.Ids 来获取一些基本的acl列表。例如，ZooDefs.Ids.OPEN_ACL_UNSAFE返回打开znode的acl列表。
     * createMode - 节点的类型，即临时，顺序或两者。这是一个枚举。
     *
     * @param zooKeeper
     * @param path
     * @param data
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void create(ZooKeeper zooKeeper, String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
}
