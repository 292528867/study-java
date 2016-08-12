package com.yk.example.rabbitmq.workqueue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by yk on 16/6/23.
 */
public class Worker {

    public static final String TASK_QUEUE_NAME = "taskQueue";

/*    public static void main(String[] args) throws Exception {
        Worker worker1 = new Worker();
        worker1.DoWork();
    }*/

    private void DoWork() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        boolean durable = true; //RabbitMQ will never lose our queue.
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, true, consumer);
    }

    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.')
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
        }
    }
}
