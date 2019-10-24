package com.ksabu.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.UUID;

/**
 * @author ksabu00
 */
public class JMSProducerTopic1 {
    // tcp协议+端口
    private static final String DEFAULT_BROKER_BIND_URL = "tcp://47.102.100.157:61616";
    private static final String TOPIC_NAME = "queue01";

    public static void main(String[] args) throws Exception {
        // 获取ActiveMQConnectionFactory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        // 直接获取连接connection，并开启
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建一次会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列参数为队列名
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建一个生产者
        MessageProducer producer = session.createProducer(topic);
        // 生产数据
        for (int i = 1; i <= 10; i++) {
            // 当前会话创建消息
            TextMessage textMessage = session.createTextMessage("data:" + UUID.randomUUID().toString().replace("-", "").substring(0, 6)  + "-"+ i);
            // 生产者提交数据
            producer.send(textMessage);
        }
        System.out.println("producer send message success");
        // 上传完释放资源
        producer.close();
        session.close();
        connection.close();
    }
}
