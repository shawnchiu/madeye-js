package cn.rejoicy.madeyecore.application.business;

import cn.rejoicy.madeyecore.domain.business.BusinessService;
import cn.rejoicy.madeyecore.viewmodel.BusinessDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void add(BusinessDTO businessDTO) {
        businessService.add(businessDTO);
    }



}
