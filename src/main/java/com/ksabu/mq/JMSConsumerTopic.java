package com.ksabu.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @author ksabu00
 * 消费者获取数据
 */
public class JMSConsumerTopic {
    private static final String DEFAULT_BROKER_BIND_URL = "tcp://47.102.100.157:61616";
    private static final String TOPIC_NAME = "Topic61616";

    public static void main(String[] args) throws Exception {
        // 获取ActiveMQFactory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        // 创建connertion
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建一次会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个队列
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建一个消费者
        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(message -> {
            if (null != message && message instanceof TextMessage){
                try {
                    TextMessage textMessage = (TextMessage)message;
                    System.out.println(textMessage.getText());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        /*// 输出信息
        TextMessage textMessage = null;
        while (true){
            // 消费者读取消息
             textMessage= (TextMessage)consumer.receive();
            if (textMessage != null){
                System.out.println(textMessage.getText());
            }else {
                break;
            }
        }*/
    }
}
