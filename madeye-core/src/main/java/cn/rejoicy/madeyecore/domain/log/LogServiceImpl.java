package cn.rejoicy.madeyecore.domain.log;

import cn.rejoicy.madeyecore.domain.log.entity.Log;
import cn.rejoicy.madeyecore.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyecore.viewmodel.LogDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 日志相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Service
public class LogServiceImpl implements LogService {
    @Override
    public Log create(LogDTO logDTO) {
        return null;
    }

    @Override
    public Log delete(String logCode) {
        return null;
    }

    @Override
    public Page<Log> findByCondition(ConditionQueryLogDTO condition) {
        return null;
    }
}
