package com.hom.protogenesis;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperConnect {

    /**
     * connectionString - ZooKeeper集合主机。
     * sessionTimeout - 会话超时（以毫秒为单位）。
     * watcher - 实现“监视器”界面的对象。ZooKeeper集合通过监视器对象返回连接状态。
     */
    // declare zookeeper instance to access ZooKeeper ensemble
    private ZooKeeper zooKeeper;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    // Method to connect zookeeper ensemble.
    public ZooKeeper connect() throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
