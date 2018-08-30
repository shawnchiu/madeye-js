package cn.rejoicy.madeyecore.application.mq;

import cn.rejoicy.madeyecore.viewmodel.LogDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息队列发送服务
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Component
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);


    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送新增日志消息到队列
     *
     * @param logDTO
     */
    public void sendLogCreateMessage(LogDTO logDTO) {
        LOGGER.info("发送新增日志消息到队列：{}", logDTO);
        // TODO: 2018/8/30 补全routingkey
        this.rabbitMessagingTemplate.convertAndSend("cn_rejoicy_madeyejs", "log.*.*.*.create", logDTO);

    }

}
