package com.ksabu.project1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther ksabu00
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * 小总结：
 *          读-读能共存
 *          读-写不能共存
 *          写-写不能共存
 */

class WriteRead2{
    private volatile Map<String, String> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public void put(String key, String value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t" + "写入开始");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t" + "写入结束");
        }finally {
            lock.writeLock().unlock();
        }

    }

    public void get(String key){
        lock.readLock().lock();
        try{
            String result = null;
            System.out.println(Thread.currentThread().getName() + "\t" + "读取开始");
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t" + "读取结束" + "\t" + result);
        }finally {
            lock.readLock().unlock();
        }
    }
}

public class WriteReadLock2 {
    public static void main(String[] args) {
        WriteRead2 wr = new WriteRead2();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                wr.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                wr. get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }
}
