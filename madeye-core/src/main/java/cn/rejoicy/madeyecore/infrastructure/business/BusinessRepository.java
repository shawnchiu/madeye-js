package cn.rejoicy.madeyecore.infrastructure.business;

import cn.rejoicy.madeyecore.domain.business.entity.Business;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

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
    void save(Business business);

    /**
     * 删除
     *
     * @param business
     * @return
     */
    void delete(Business business);

    /**
     * 根据业务编码查询
     *
     * @param businessCode
     * @return
     */
    Business findByBusinessCode(String businessCode);

    /**
     * 根据业务名查询
     *
     * @param businessName
     * @return
     */
    Business findByBusinessName(String businessName);

    /**
     * 根据apiToken查询
     *
     * @param apiToken
     * @return
     */
    Business findByApiToken(String apiToken);

    /**
     * 条件查询（分页）
     *
     * @param specification
     * @param pageable
     * @return
     */
    Page<Business> findByCondition(Specification<Business> specification, Pageable pageable);

}
