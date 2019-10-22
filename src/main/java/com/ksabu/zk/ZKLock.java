package com.ksabu.zk;

/**
 * @author ksabu00
 * 存在一个接口有解锁开锁的方法，为分布式锁
 */
public interface ZKLock {
    public void lock();
    public void unlock();
}
