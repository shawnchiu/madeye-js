package cn.rejoicy.madeyecore.base.conveter;

import cn.rejoicy.madeyecore.domain.business.entity.Business;
import cn.rejoicy.madeyecore.viewmodel.BusinessDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */
public class BusinessConverter {

    /**
     * from business 2 businessdto
     *
     * @return
     */
    public static Converter<Business, BusinessDTO> getBusinessConveter() {

        return business -> {
            BusinessDTO businessDTO = new BusinessDTO();
            businessDTO.setBusinessName(business.getBusinessName());
            businessDTO.setBusinessCode(business.getBusinessCode());
            businessDTO.setStatus(business.getStatus());
            businessDTO.setApiToken(business.getApiToken());
            return businessDTO;
        };
    }

    /**
     * from businessdto 2 business
     *
     * @return
     */
    public static Converter<BusinessDTO, Business> getBusinessDTOConveter() {

        return businessDTO -> {
            Business business = new Business();
            business.setBusinessName(businessDTO.getBusinessName());
            business.setBusinessCode(businessDTO.getBusinessCode());
            business.setStatus(businessDTO.getStatus());
            business.setApiToken(businessDTO.getApiToken());
            return business;
        };
    }
}
