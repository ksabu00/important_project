package com.ksabu.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author ksabu00
 */
public class JMSConsumerTopic1 {
    private static final String DEFAULT_BROKER_BIND_URL = "tcp://47.102.100.157:61616";
    private static final String TOPIC_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        // 获取ActiveMQConnectionFactory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        // 获取connection
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建当前会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个队列
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建一个消费者
        MessageConsumer consumer = session.createConsumer(topic);
        // 消费数据且判断数据是否存在
        consumer.setMessageListener(message -> {
            if (message != null && message instanceof TextMessage){
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println("获取数据" + textMessage.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
