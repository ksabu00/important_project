package com.ksabu.testzk;



import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author ksabu00
 * 继承抽象类
 */
public class ZkDistributedLock extends ZkAbstractTemplateLock {

    @Override
    public boolean tryZkLock() {
        try {
            // 能创建成功则抢占成功
            zkClient.createEphemeral(path);
            return true;
        	} catch (Exception e) {
        		//e.printStackTrace();
        	}
        return false;
    }

    @Override
    public void waitZkLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null){
                    countDownLatch.countDown();
                }
            }
        };
        // 调用监听方法subscribeDataChanges()
        zkClient.subscribeDataChanges(path, iZkDataListener);
        // 判断是否存在这个节点，存在则等待
        if (zkClient.exists(path)){
            // 删掉之后才能创建
            // 先将进程卡在这里
            countDownLatch = new CountDownLatch(1);

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(path, iZkDataListener);
    }
}
