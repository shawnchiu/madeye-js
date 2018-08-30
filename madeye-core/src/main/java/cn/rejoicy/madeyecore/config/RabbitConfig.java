package cn.rejoicy.madeyecore.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 消息队列配置
 * @author shawn
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queryCreateLog() {
        return new Queue("log-create", true);
    }


    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("cn_rejoicy_madeyejs");
    }


    @Bean
    public Binding bindingQueryCreateLog() {
        return BindingBuilder.bind(queryCreateLog()).to(topicExchange()).with("log.*.*.*.create");
    }

}
