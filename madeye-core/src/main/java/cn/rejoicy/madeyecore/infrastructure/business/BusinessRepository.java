package cn.rejoicy.madeyecore.infrastructure.business;

import cn.rejoicy.madeyecore.domain.business.entity.Business;

/**
 * 业务模块基础设施
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface BusinessRepository {
    /**
     * 保存
     *
     * @param business
     * @return
     */
    Business save(Business business);

    /**
     * 删除
     *
     * @param business
     * @return
     */
    void delete(Business business);
}
