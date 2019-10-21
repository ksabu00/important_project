package com.ksabu.testzk;

/**
 * @author ksabu00
 * 新建一个多的接口，具有开锁关锁的功能
 */
public interface ZKLock {
    public void lock();
    public  void unlock();
}
