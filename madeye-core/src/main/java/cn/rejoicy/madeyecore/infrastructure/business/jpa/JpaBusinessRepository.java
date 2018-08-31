package cn.rejoicy.madeyecore.infrastructure.business.jpa;

import cn.rejoicy.madeyecore.domain.business.entity.Business;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 业务相关操作 jpa
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface JpaBusinessRepository extends JpaRepository<Business, Long> {

    /**
     * 根据业务编码查询业务
     *
     * @param businessCode
     * @return
     */
    Business findByBusinessCode(String businessCode);

    /**
     * 根据业务名查询业务
     *
     * @param businessName
     * @return
     */
    Business findOneByBusinessName(String businessName);

    /**
     * 根据apiToken查询业务
     *
     * @param apiToken
     * @return
     */
    Business findOneByApiToken(String apiToken);

    /**
     * 条件查询
     * @param specification
     * @param pageable
     * @return
     */
    Page<Business> findAll(Specification<Business> specification, Pageable pageable);
}
