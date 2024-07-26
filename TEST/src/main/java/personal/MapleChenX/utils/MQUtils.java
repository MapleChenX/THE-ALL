package personal.MapleChenX.utils;


import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQUtils {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String queueName, String message) {
        // 创建队列
        amqpAdmin.declareQueue(new Queue(queueName, true));

        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }


}
