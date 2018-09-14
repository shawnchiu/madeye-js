package cn.rejoicy.madeyejs.core.domain.business;

import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.domain.business.enums.BusinessStatusEnum;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryBusiness;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface BusinessService {

    /**
     * 添加业务
     *
     * @param businessDTO
     */
    void add(BusinessDTO businessDTO) throws Exception;

    /**
     * 修改业务状态
     *
     * @param businessCode
     * @param status
     */
    void updateStatus(String businessCode, BusinessStatusEnum status) throws Exception;

    /**
     * 删除业务
     *
     * @param businessCode
     */
    void delete(String businessCode);

    /**
     * 根据apiToken查询
     *
     * @param apiToken
     * @return
     */
    Business findByApiToken(String apiToken);

    /**
     * 根据条件查询业务
     *
     * @param condition
     * @return
     */
    Page<Business> findByCondition(ConditionQueryBusiness condition);

    /**
     * 查询全部
     * @return
     */
    List<Business> findAll();
}
