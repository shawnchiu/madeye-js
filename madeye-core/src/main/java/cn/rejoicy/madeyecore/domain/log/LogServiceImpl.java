package cn.rejoicy.madeyecore.domain.log;

import ch.qos.logback.classic.pattern.LoggerConverter;
import cn.rejoicy.madeyecore.domain.log.entity.Log;
import cn.rejoicy.madeyecore.infrastructure.log.LogRepository;
import cn.rejoicy.madeyecore.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyecore.viewmodel.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 日志相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Override
    public Log create(LogDTO logDTO) {
        Log log = new Log();
        log.setLogCode(UUID.randomUUID().toString().replace("-", ""));
        logRepository.save(log);
        return log;
    }

    @Override
    public void delete(String logCode) {
        Log log = logRepository.findByLogCode(logCode);
        if (log == null) {
            return;
        }
        logRepository.delete(log);
    }

    @Override
    public Page<Log> findByCondition(ConditionQueryLogDTO condition) {
        return null;
    }
}
