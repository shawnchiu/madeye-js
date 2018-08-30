package cn.rejoicy.madeyecore.infrastructure.log;

import cn.rejoicy.madeyecore.domain.business.entity.Business;
import cn.rejoicy.madeyecore.domain.log.entity.Log;

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
}
