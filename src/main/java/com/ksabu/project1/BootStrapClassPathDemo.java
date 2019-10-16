package com.ksabu.project1;

import java.net.URL;

/**
 * @author ksabu00
 * jvm启动类加载器加载了哪些包？
 */
public class BootStrapClassPathDemo {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element :
                urls) {
            System.out.println(element.toExternalForm());
        }
    }
}
