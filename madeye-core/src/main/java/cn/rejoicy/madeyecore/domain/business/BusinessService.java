package cn.rejoicy.madeyecore.domain.business;

import cn.rejoicy.madeyecore.domain.business.enums.BusinessStatusEnum;
import cn.rejoicy.madeyecore.viewmodel.BusinessDTO;

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
    void add(BusinessDTO businessDTO);

    /**
     * 修改业务状态
     *
     * @param businessCode
     * @param status
     */
    void updateStatus(String businessCode, BusinessStatusEnum status);

    /**
     * 删除业务
     *
     * @param businessCode
     */
    void delete(String businessCode);
}
