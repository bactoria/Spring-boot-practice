package com.example.RabbitMQ._examples._1_hello_world;

import com.rabbitmq.client.*;
import java.io.IOException;

class SendMessage {

    private Connection connection;
    private Channel channel;
    private Constant constant = new Constant();

    protected SendMessage() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(constant.QUEUE_NAME, true, false, false, null);
//        channel.exchangeDeclare(constant.EXCHANGE_NAME, BuiltinExchangeType.TOPIC, true);
//    channel.queueBind(constant.QUEUE_NAME, constant.EXCHANGE_NAME, "black.*");
    }

    protected void sendMessage(String message) {
        try {
//            channel.basicPublish(constant.EXCHANGE_NAME, "black.xxxx", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            channel.basicPublish(constant.EXCHANGE_NAME, "black.xxxx", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void stopConnect() throws Exception {
        channel.close();
        connection.close();
    }

}