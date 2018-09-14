package cn.rejoicy.madeyejs.core.application.log;

import cn.rejoicy.madeyejs.core.application.mq.Sender;
import cn.rejoicy.madeyejs.core.base.conveter.LogConverter;
import cn.rejoicy.madeyejs.core.domain.business.BusinessService;
import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.domain.log.LogService;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class LogManager {

    private final LogService logService;

    private final Sender sender;

    private final BusinessService businessService;

    @Autowired
    public LogManager(LogService logService, Sender sender, BusinessService businessService) {
        this.logService = logService;
        this.sender = sender;
        this.businessService = businessService;
    }

    /**
     * 新增日志
     *
     * @param logDTO
     */
    public void create(LogDTO logDTO) throws Exception {
        if (StringUtils.isEmpty(logDTO.getApiToken())) {
            throw new Exception("apiToken is missing");
        }
        Business business = businessService.findByApiToken(logDTO.getApiToken());
        if (business == null) {
            throw new Exception("invalid apiToken ");
        }

        Log log = logService.preCreate(logDTO, business);
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

    public Page<LogDTO> findByCondition(ConditionQueryLogDTO condition) {
        Page<Log> logPage =  logService.findByCondition(condition);
        return logPage.map(LogConverter.getLogConverter());
    }
}
