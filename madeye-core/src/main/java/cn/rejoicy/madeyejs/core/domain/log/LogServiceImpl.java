package cn.rejoicy.madeyejs.core.domain.log;

import cn.rejoicy.madeyejs.core.base.conveter.LogConverter;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.infrastructure.log.LogRepository;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
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
    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log preCreate(LogDTO logDTO) {
        Log log = LogConverter.getLogDTOConveter().convert(logDTO);
        log.setLogCode(UUID.randomUUID().toString().replace("-", ""));
        return log;
    }

    @Override
    public Log create(Log log) {
        return logRepository.save(log);
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
