package cn.rejoicy.madeyejs.core.application.log;

import cn.rejoicy.madeyejs.core.application.mq.Sender;
import cn.rejoicy.madeyejs.core.domain.log.LogService;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class LogManager {

    private final LogService logService;

    private final Sender sender;

    @Autowired
    public LogManager(LogService logService, Sender sender) {
        this.logService = logService;
        this.sender = sender;
    }

    /**
     * 新增日志
     *
     * @param logDTO
     */
    public void create(LogDTO logDTO) {
        Log log = logService.preCreate(logDTO);
        // TODO: 2018/9/1 通过事件处理
        sender.sendLogCreateMessage(log);
    }

    /**
     * 删除日志
     *
     * @param locCode
     * @throws Exception
     */
    public void delete(String locCode) throws Exception {
        if (StringUtils.isEmpty(locCode)) {
            throw new Exception("日志编码不能为空");
        }

        logService.delete(locCode);
    }
}
