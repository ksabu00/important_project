package com.ksabu.zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author ksabu00
 */
public class ZkDistributedLock extends ZKLockImpl {
    @Override
    public boolean tryZkLock() {
       try {
           // 创建成功则返回true
           zkClient.createEphemeral(path);
           return  true;
       	} catch (Exception e) {
       		//e.printStackTrace();
           return false;
       	}
    }

    @Override
    public void waitZkLock() {
        // 调用监听方法subscribeDataChanges()
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                // 删除先进行非空判断
                if (countDownLatch != null){
                    countDownLatch.countDown();
                }
            }
        };
        // 调用监听方法监听path的改变
        zkClient.subscribeDataChanges(path,listener);
        // 然后再次判断是否进入该节点
        if (zkClient.exists(path)){
            // 如果存在该节点
            countDownLatch = new CountDownLatch(1);

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(path,listener);
    }
}
