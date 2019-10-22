package com.ksabu.zk;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author ksabu00
 */
public abstract class ZKLockImpl implements ZKLock {
    // 连接zookeeper服务器 一定要加端口
    public static final String ZKSERVER1 = "47.102.100.157:2181";
    public static final int TIME_OUT = 40 * 1000;
    public String path = "/testzk";
    CountDownLatch countDownLatch = null;
    ZkClient zkClient = new ZkClient(ZKSERVER1,TIME_OUT);



    @Override
    public void lock() {
        if (tryZkLock()){
            System.out.println(Thread.currentThread().getName() + "抢锁成功");
        }else{
            // 等待锁的释放后再去试着抢锁
            waitZkLock();

            lock();
        }
    }

    // 模板设计模式，固定化的流程升级到父类写死规范，但是具体落地实现下方到子类
    public abstract boolean tryZkLock();
    public abstract void waitZkLock();
    @Override
    public void unlock() {
        // 当zookeeper的某个节点存在，即可以调用方法来删除节点并释放锁
        if (zkClient != null){
            zkClient.close();// 等价于在zk服务器上执行quit命令
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "释放锁");
        System.out.println();
    }
}
