package com.ksabu.project1;

import java.util.Random;

/**
 * @author ksabu00
 */
public class OutOfMemoryDemo {
    public static void main(String[] args) {
        String str = "www.ksabu.com";

        while(true){
            str += str + new Random().nextInt(1000);
        }
        /*long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");*/
    }
}
