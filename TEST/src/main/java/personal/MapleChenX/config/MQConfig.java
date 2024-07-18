package personal.MapleChenX.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import personal.MapleChenX.service.impl.ImportServiceImpl;

@Configuration
public class MQConfig {


//    // 声明mq队列
//     @Bean
//     public Queue queue() {
//         return new Queue(ImportServiceImpl.QUEUE_NAME, true);
//     }

}
