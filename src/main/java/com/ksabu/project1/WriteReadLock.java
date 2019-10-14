package com.ksabu.project1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksabu00
 */

class WriteRead{
    private volatile Map<String, String> map = new HashMap<>();

    public void put(String key, String value){
        System.out.println(Thread.currentThread().getName() + "\t" + "写入开始");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t" + "写入结束");
    }

    public void get(String key){
        String value = null;
        System.out.println(Thread.currentThread().getName() + "\t" + "读取开始");
        value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t" + "读取结束" + "\t" + value);
    }
}
public class WriteReadLock {
    public static void main(String[] args) {
        WriteRead wr = new WriteRead();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                wr.put(finalI + "", finalI + "");
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                wr. get(finalI + "");
            }).start();
        }
    }
}
