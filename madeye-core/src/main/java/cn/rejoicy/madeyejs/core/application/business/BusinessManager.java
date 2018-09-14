package cn.rejoicy.madeyejs.core.application.business;

import cn.rejoicy.madeyejs.core.base.conveter.BusinessConverter;
import cn.rejoicy.madeyejs.core.domain.business.BusinessService;
import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

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

    /**
     * 根据Code删除
     *
     * @param businessCode
     */
    public void delete(String businessCode) {
        businessService.delete(businessCode);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<BusinessDTO> findAll() {
        List<Business> businesses = businessService.findAll();
        return BusinessConverter.getBusinessListConveter().convert(businesses);
    }
}
