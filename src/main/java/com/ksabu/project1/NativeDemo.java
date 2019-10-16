package com.ksabu.project1;

/**
 * @author ksabu00
 */
public class NativeDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        /**
         * start()方法后面调用的是start()方法,start0()方法是被Native修饰的方法，
         * 即java已经不能完成相关的操作了，直接交给了c++
         * private native void start0();
         * 单个线程只能被启动一次，原因是线程启动就判断线程的状态，如果启动过状态变为1，
         * 再次启动时就会直接抛出异常java.lang.IllegalThreadStateException
         * 源码：
         * if (threadStatus != 0)
         *       throw new IllegalThreadStateException();
         *       group.add(this);
         *
         *         boolean started = false;
         *         try {
         *             start0();
         *             started = true;
         *         }
         *
         */
        //thread.start();
    }
}
