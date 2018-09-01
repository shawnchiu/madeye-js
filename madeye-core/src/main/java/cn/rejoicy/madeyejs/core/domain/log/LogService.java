package cn.rejoicy.madeyejs.core.domain.log;

import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.data.domain.Page;

/**
 * 日志相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface LogService {

    /**
     * 预处理日志
     *
     * @param logDTO
     * @return
     */
    Log preCreate(LogDTO logDTO);

    /**
     * 创建日志
     *
     * @param log
     * @return
     */
    Log create(Log log);

    /**
     * 删除日志
     *
     * @param logCode
     * @return
     */
    void delete(String logCode);

    /**
     * 条件查询
     *
     * @param condition
     * @return
     */
    Page<Log> findByCondition(ConditionQueryLogDTO condition);
}
