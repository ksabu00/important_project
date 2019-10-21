package com.ksabu.testzk;

/**
 * @author ksabu00
 * 分布式锁项目
 *
 */
public class OrderNumberGenerateUtil {
    // 订单号的初始值
    private static int Num = 0;

    public String getOrderNumber(){

        return "" + (++Num);
    }
}
