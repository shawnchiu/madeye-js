package cn.rejoicy.madeyejs.core.application.mq;

import cn.rejoicy.madeyejs.core.domain.log.LogService;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private final LogService logService;

    @Autowired
    public Receiver(LogService logService) {
        this.logService = logService;
    }

    @RabbitListener(queues = "log-create")
    public void receiveLogCreateMsg(Log log) {
        if (log == null) {
            return;
        }
        LOGGER.info("接受到新增日志消息： {}", log);

        logService.create(log);
    }
}
