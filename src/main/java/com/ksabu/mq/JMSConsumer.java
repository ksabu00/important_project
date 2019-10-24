package com.ksabu.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.CamelQueue;

import javax.jms.*;


/**
 * @author ksabu00
 * 消费者获取数据
 */
public class JMSConsumer {
    private static final String DEFAULT_BROKER_BIND_URL = "tcp://47.102.100.157:61616";
    private static final String QUEUE_NAME = "queue61616";

    public static void main(String[] args) throws Exception {
        // 获取ActiveMQFactory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        // 创建connertion
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建一次会话
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        // 创建一个队列
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建一个消费者
        MessageConsumer consumer = session.createConsumer(queue);

        // 采用监听器写法
        /*consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

            }
        });*/
        // lambda表达式，且单个参数类型省略括号省略
        consumer.setMessageListener(message -> {
            if (message != null && message instanceof TextMessage){
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println("接收到消息" + textMessage.getText());
                    session.commit();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        });

    }
}
