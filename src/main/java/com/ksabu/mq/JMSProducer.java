package com.ksabu.mq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.UUID;

/**
 * @author ksabu00
 * 生产者发布消息
 */
public class JMSProducer {
    private static final String DEFAULT_BROKER_BIND_URL = "tcp://47.102.100.157:61616";
    private static final String QUEUE_NAME = "queue61616";

    public static void main(String[] args) throws Exception {
        // 第一步获取ActiveMQConnectionFactory对象
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        // 获取conncetion
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建一次会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 创建一个队列
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建一个生成者
        MessageProducer producer = session.createProducer(queue);
        // 提交数据到activemq
        for (int i = 1; i <= 8; i++) {
            TextMessage message = session.createTextMessage(UUID.randomUUID().toString().replace("-", "").substring(0, 6) + "\t" + i);
            producer.send(message);

        }
        // 先进后出后进先出，关闭资源

        producer.close();
        session.commit();
        session.close();
        connection.close();

        System.out.println("producer send message success");
    }
}
