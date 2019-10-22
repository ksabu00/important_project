package com.ksabu.zk;

import java.util.UUID;

/**
 * @author ksabu00
 * 创建订单的工具类
 */
public class GetNumUtil {
    private  static int orderNum = 0;
    public void getOrderNum(){
        System.out.println("订单编号 " + UUID.randomUUID().toString().replace("-", "").toString() + "-" + (++orderNum));
    }
}
