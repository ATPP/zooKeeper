package com.hom.protogenesis;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkMain {

    private static ZookeeperConnect connect;
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) {
        String path = "/zookeeper/onenode";
        byte[] data = "one data".getBytes();
        try {
            connect = new ZookeeperConnect();
            zooKeeper = connect.connect();

            //创建节点
//            ZkCreate.create(zooKeeper, path, data);

            //判断节点是否存在
//            Stat stat = ZkExists.zkNodeExists(zooKeeper, path);
//            if (null != stat) {
//                System.out.println("node is exist and node version is " + stat.getVersion());
//            }else {
//                System.out.println("node is not exist, plase create it");
//            }

            //获取数据
//            ZkGetData.getNodeDate(zooKeeper,path);

            //修改数据
            ZkSetData.setData(zooKeeper, path, "two data".getBytes());
            ZkGetData.getNodeDate(zooKeeper,path);

            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
