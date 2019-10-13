package com.ksabu.project1;

/**
 * @author ksabu00
 */

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1  故障现象
 *
 * 2  导致原因
 *
 * 3  解决方法
 * 	3.1 Vector()
 *  3.2 Collections.synchronizedList();
 *  3.3 CopyOnWriteArrayList ----> 读写分离；写实复制
 *
 */

public class NotSafeDemo {
    public static void main(String[] args) {
        // 程序每次运行的程序结果都不一致，由于HashMap是线程不安全的
        //Map<Object, Object> map = new HashMap<>();

        // 可以使用ConcurrentHashMap来解决
        Map<Object, Object> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().subSequence(0, 6));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }
    public static void setNotSafe() {
        // 程序每次运行的程序结果都不一致，由于HashSet是线程不安全的
        //Set<String> set = new HashSet<String>();

        // 可以使用CopyOnWriteArraySet来解决
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(1, 6));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}

/**笔记
 * 	  写时复制
 CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 复制出一个新的容器Object[] newElements，然后新的容器Object[] newElements里添加元素，添加完元素之后，
 再将原容器的引用指向新的容器 setArray(newElements);。这样做的好处是可以对CopyOnWrite容器进行并发的读，
 而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器

     public boolean add(E e)
     {
     final ReentrantLock lock = this.lock;

     lock.lock();

     try{
     Object[] ele ments = getArray();
     int len = elements.length;
     Object[] newElements = Arrays.copyOf(elements, len + 1);
     newElements[len] = e;
     setArray(newElements);
     return true;
     }
     finally {
     lock.unlock();
     }
     }
 **/
