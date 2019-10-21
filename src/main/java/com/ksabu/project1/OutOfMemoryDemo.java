package com.ksabu.project1;

import java.util.Random;

/**
 * @author ksabu00
 * result:
 * -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 * Heap
 * C:\Installation_path\jdk\bin\java.exe -Xms1024m -Xmx1024m -XX:+PrintGCDetails "-javaagent:C:\Installation_path\idea\IntelliJ IDEA 2019.2.3\lib\idea_rt.jar=52518:C:\Installation_path\idea\IntelliJ IDEA 2019.2.3\bin" -Dfile.encoding=UTF-8 -classpath C:\Installation_path\jdk\jre\lib\charsets.jar;C:\Installation_path\jdk\jre\lib\deploy.jar;C:\Installation_path\jdk\jre\lib\ext\access-bridge-64.jar;C:\Installation_path\jdk\jre\lib\ext\cldrdata.jar;C:\Installation_path\jdk\jre\lib\ext\dnsns.jar;C:\Installation_path\jdk\jre\lib\ext\jaccess.jar;C:\Installation_path\jdk\jre\lib\ext\jfxrt.jar;C:\Installation_path\jdk\jre\lib\ext\localedata.jar;C:\Installation_path\jdk\jre\lib\ext\nashorn.jar;C:\Installation_path\jdk\jre\lib\ext\sunec.jar;C:\Installation_path\jdk\jre\lib\ext\sunjce_provider.jar;C:\Installation_path\jdk\jre\lib\ext\sunmscapi.jar;C:\Installation_path\jdk\jre\lib\ext\sunpkcs11.jar;C:\Installation_path\jdk\jre\lib\ext\zipfs.jar;C:\Installation_path\jdk\jre\lib\javaws.jar;C:\Installation_path\jdk\jre\lib\jce.jar;C:\Installation_path\jdk\jre\lib\jfr.jar;C:\Installation_path\jdk\jre\lib\jfxswt.jar;C:\Installation_path\jdk\jre\lib\jsse.jar;C:\Installation_path\jdk\jre\lib\management-agent.jar;C:\Installation_path\jdk\jre\lib\plugin.jar;C:\Installation_path\jdk\jre\lib\resources.jar;C:\Installation_path\jdk\jre\lib\rt.jar;C:\workspace\template\target\classes;C:\Users\18229\.m2\repository\org\springframework\boot\spring-boot-starter\2.1.9.RELEASE\spring-boot-starter-2.1.9.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\boot\spring-boot\2.1.9.RELEASE\spring-boot-2.1.9.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\spring-context\5.1.10.RELEASE\spring-context-5.1.10.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\spring-aop\5.1.10.RELEASE\spring-aop-5.1.10.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\spring-beans\5.1.10.RELEASE\spring-beans-5.1.10.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\spring-expression\5.1.10.RELEASE\spring-expression-5.1.10.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.1.9.RELEASE\spring-boot-autoconfigure-2.1.9.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.1.9.RELEASE\spring-boot-starter-logging-2.1.9.RELEASE.jar;C:\Users\18229\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\18229\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\18229\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.11.2\log4j-to-slf4j-2.11.2.jar;C:\Users\18229\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;C:\Users\18229\.m2\repository\org\slf4j\jul-to-slf4j\1.7.28\jul-to-slf4j-1.7.28.jar;C:\Users\18229\.m2\repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;C:\Users\18229\.m2\repository\org\springframework\spring-core\5.1.10.RELEASE\spring-core-5.1.10.RELEASE.jar;C:\Users\18229\.m2\repository\org\springframework\spring-jcl\5.1.10.RELEASE\spring-jcl-5.1.10.RELEASE.jar;C:\Users\18229\.m2\repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;C:\Users\18229\.m2\repository\org\slf4j\slf4j-api\1.7.28\slf4j-api-1.7.28.jar com.ksabu.project1.OutOfMemoryDemo
 * [GC (Allocation Failure) [PSYoungGen: 236858K->33696K(305664K)] 236858K->33704K(1005056K), 0.0218893 secs] [Times: user=0.11 sys=0.00, real=0.02 secs]
 * [GC (Allocation Failure) [PSYoungGen: 268142K->33552K(305664K)] 268150K->164608K(1005056K), 0.1021541 secs] [Times: user=0.58 sys=0.02, real=0.10 secs]
 * [GC (Allocation Failure) [PSYoungGen: 174485K->776K(305664K)] 305541K->328392K(1005056K), 0.0453201 secs] [Times: user=0.11 sys=0.03, real=0.05 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 262920K->0K(305664K)] [ParOldGen: 589696K->132229K(699392K)] 852616K->132229K(1005056K), [Metaspace: 3229K->3229K(1056768K)], 0.0238453 secs] [Times: user=0.00 sys=0.02, real=0.02 secs]
 * [GC (Allocation Failure) [PSYoungGen: 131040K->0K(305664K)] 525349K->394309K(1005056K), 0.0016123 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 0K->0K(262656K)] 394309K->394309K(962048K), 0.0014708 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(262656K)] [ParOldGen: 394309K->393798K(699392K)] 394309K->393798K(962048K), [Metaspace: 3229K->3229K(1056768K)], 0.0571049 secs] [Times: user=0.27 sys=0.02, real=0.06 secs]
 * [GC (Allocation Failure) [PSYoungGen: 0K->0K(305664K)] 393798K->393798K(1005056K), 0.0010548 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(305664K)] [ParOldGen: 393798K->393778K(699392K)] 393798K->393778K(1005056K), [Metaspace: 3229K->3229K(1056768K)], 0.0448044 secs] [Times: user=0.28 sys=0.00, real=0.04 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.Arrays.copyOf(Arrays.java:3332)
 * 	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
 * 	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
 * 	at java.lang.StringBuilder.append(StringBuilder.java:208)
 * 	at com.ksabu.project1.OutOfMemoryDemo.main(OutOfMemoryDemo.java:24)
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
