package cn.rejoicy.madeyejs.core.infrastructure.log;

import cn.rejoicy.madeyejs.core.infrastructure.log.jpa.JpaLogRepository;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Repository
public class LogRepositoryImpl implements LogRepository {

    @Autowired
    private JpaLogRepository jpaLogRepository;

    @Override
    public Log save(Log log) {
        return jpaLogRepository.save(log);
    }

    @Override
    public void delete(Log log) {
        jpaLogRepository.delete(log);
    }

    @Override
    public void delete(List<Log> logList) {
        jpaLogRepository.delete(logList);
    }

    @Override
    public void deleteByBusinessCode(String businessCode) {
        jpaLogRepository.deleteAllByBusiness_BusinessCode(businessCode);
    }

    @Override
    public Log findByLogCode(String logCode) {
        return jpaLogRepository.findOneByLogCode(logCode);
    }
}
