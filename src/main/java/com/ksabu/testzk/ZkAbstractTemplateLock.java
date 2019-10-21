package com.ksabu.testzk;




import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author ksabu00
 * 实现两个方法
 */
public abstract  class ZkAbstractTemplateLock implements ZKLock {
    // 连接zookeeper服务器 一定要加端口
    private static final String ZKSERVER = "47.102.100.157:2181";
    private static final int TIME_OUT = 45 * 1000;
    protected String path = "/tempzk";
    ZkClient zkClient = new ZkClient(ZKSERVER, TIME_OUT);
    //ZkClient zkClient = new ZkClient(ZKSERVER,TIME_OUT);
    CountDownLatch countDownLatch = null;
    @Override
    public void lock() {
        // 首先试着抢锁
        if(tryZkLock()){
            System.out.println();
            System.out.println(Thread.currentThread().getName() + "\t" + "抢锁成功");
        }else {
            // 没抢到则等待
            waitZkLock();
            // 等待一段时间后有机会再次抢锁
            lock();
        }
    }
    // 模板设计模式，固定化的流程升级到父类写死规范，但是具体落地实现下方到子类
    public abstract boolean tryZkLock();
    public abstract void waitZkLock();
    @Override
    public void unlock() {
        if (zkClient != null){
            zkClient.close();// 等价于在zk服务器上执行quit命令
        }
        //System.out.println(Thread.currentThread().getName() + "\t" + "释放锁成功");

    }
}
