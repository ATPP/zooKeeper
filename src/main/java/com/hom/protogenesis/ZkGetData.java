package com.hom.protogenesis;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

public class ZkGetData {

    /**
     * path - Znode路径。
     * watcher - 监视器类型的回调函数。当指定的znode的数据改变时，ZooKeeper集合将通过监视器回调进行通知。这是一次性通知。
     * stat - 返回znode的元数据。
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    static String result;

    public static String getNodeDate(final ZooKeeper zooKeeper, final String path) throws KeeperException, InterruptedException {
        Stat stat = ZkExists.zkNodeExists(zooKeeper, path);
        //如果节点存在
        if (null != stat) {
            byte[] b = zooKeeper.getData(path, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                        switch (watchedEvent.getState()) {
                            case Expired:
                                countDownLatch.countDown();
                                break;
                        }
                    } else {
                        try {
                            byte[] bytes = zooKeeper.getData(path, false, null);
                            String data = new String(bytes, "UTF-8");
                            System.out.println("bn:" + data);
                            countDownLatch.countDown();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, null);
            try {
                result = new String(b, "UTF-8");
                System.out.println("b:" + result);
                countDownLatch.await();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("node is not exist");
        }
        return result;
    }
}
