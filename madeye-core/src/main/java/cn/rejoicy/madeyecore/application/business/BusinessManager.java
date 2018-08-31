package cn.rejoicy.madeyecore.application.business;

import cn.rejoicy.madeyecore.base.conveter.BusinessConverter;
import cn.rejoicy.madeyecore.domain.business.BusinessService;
import cn.rejoicy.madeyecore.domain.business.entity.Business;
import cn.rejoicy.madeyecore.viewmodel.BusinessDTO;
import cn.rejoicy.madeyecore.viewmodel.ConditionQueryBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class BusinessManager {

    private final BusinessService businessService;

    @Autowired
    public BusinessManager(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * 添加业务模块
     *
     * @param businessDTO
     */
    public void add(BusinessDTO businessDTO) throws Exception {
        businessService.add(businessDTO);
    }

    /**
     * 根据条件查询
     *
     * @param condition
     * @return
     */
    public Page<BusinessDTO> findByCondition(ConditionQueryBusiness condition) {
        Page<Business> businesses = businessService.findByCondition(condition);
        return businesses.map(BusinessConverter.getBusinessConveter());
    }
}
