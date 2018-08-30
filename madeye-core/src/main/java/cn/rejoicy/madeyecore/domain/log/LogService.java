package cn.rejoicy.madeyecore.domain.log;

import cn.rejoicy.madeyecore.domain.log.entity.Log;
import cn.rejoicy.madeyecore.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyecore.viewmodel.LogDTO;
import org.springframework.data.domain.Page;

/**
 * 日志相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface LogService {

    /**
     * 创建日志
     *
     * @param logDTO
     * @return
     */
    Log create(LogDTO logDTO);

    /**
     * 删除日志
     *
     * @param logCode
     * @return
     */
    Log delete(String logCode);

    /**
     * 条件查询
     *
     * @param condition
     * @return
     */
    Page<Log> findByCondition(ConditionQueryLogDTO condition);
}
