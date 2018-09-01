package cn.rejoicy.madeyejs.core.application.mq;

import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
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

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public Sender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 发送新增日志消息到队列
     *
     * @param log
     */
    public void sendLogCreateMessage(Log log) {
        LOGGER.info("发送新增日志消息到队列：{}", log);
        // TODO: 2018/8/30 补全routingkey
        this.rabbitTemplate.convertAndSend("cn_rejoicy_madeyejs", "log.*.*.*.create", log);
    }

}
