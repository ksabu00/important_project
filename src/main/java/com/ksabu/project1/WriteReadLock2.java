package com.ksabu.project1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ksabu00
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
            String value = null;
            System.out.println(Thread.currentThread().getName() + "\t" + "读取开始");
            value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t" + "读取结束" + "\t" + value);
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
