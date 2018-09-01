package cn.rejoicy.madeyejs.core.infrastructure.log;

import cn.rejoicy.madeyejs.core.domain.log.entity.Log;

import java.util.List;

/**
 * 业务模块基础设施
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface LogRepository {
    /**
     * 保存
     *
     * @param log
     * @return
     */
    Log save(Log log);

    /**
     * 删除日志
     *
     * @param log
     */
    void delete(Log log);

    /**
     * 批量删除日志
     *
     * @param logList
     */
    void delete(List<Log> logList);

    /**
     * 删除业务下的所有日志
     */
    void deleteByBusinessCode(String businessCode);

    /**
     * 根据日志编号查询日志
     *
     * @param logCode
     * @return
     */
    Log findByLogCode(String logCode);
}
