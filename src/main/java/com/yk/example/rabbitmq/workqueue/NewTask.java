package com.yk.example.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * Created by yk on 16/6/23.
 */
public class NewTask {

    public static final String TASK_QUEUE_NAME = "taskQueue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        boolean durable = true;//RabbitMQ will never lose our queue.
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
        for (int i = 0; i < 10; i++) {
            String message = getMessage(args) + " " + i;
            //持久化 rabbitmq重启后消息也不会丢失
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x]  send '" + message + "'");
        }
    }

    private static String getMessage(String[] args) {
        if (args.length < 1)
            return "hello world";
        return joinStrings(args, "");
    }

    private static String joinStrings(String[] args, String delimiter) {
        int length = args.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(args[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(args[i]);
        }
        return words.toString();
    }


}
