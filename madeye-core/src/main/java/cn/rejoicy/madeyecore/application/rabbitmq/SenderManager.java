package cn.rejoicy.madeyecore.application.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

/**
 * 消息队列发送服务
 * @author shawnchiu
 * @date 2018/8/30
 */
@Component
public class SenderManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(SenderManager.class);

    private final RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    public SenderManager(RabbitMessagingTemplate rabbitMessagingTemplate) {
        this.rabbitMessagingTemplate = rabbitMessagingTemplate;
    }

//
//    /**
//     * 向ASK发送订单信息
//     *
//     * @param event
//     */
//    public void sendAskCardRabbitMQ(TradeEvent event) {
//        rabbitMessagingTemplate.setMessageConverter(new MappingJackson2MessageConverter());
//
//        String key = getRoutingKey(event);
//        //System.err.println(key);
//
//        ResponseResult responseResult = new ResponseResult();
//        responseResult.setCommandName(ASKCARD_QUEUE_NAME);
//        responseResult.put("tradeEvent", event);
//
//        log.info("发送交易至ask {}", event);
//
//        this.rabbitMessagingTemplate.convertAndSend(ASKCARD_EXCHANGE_NAME, key, responseResult);
//    }
}
