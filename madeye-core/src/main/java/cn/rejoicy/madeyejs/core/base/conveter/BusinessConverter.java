package cn.rejoicy.madeyejs.core.base.conveter;

import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConversionServiceFactory;

import java.util.ArrayList;
import java.util.List;

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
            businessDTO.setBusinessId(business.getId());
            businessDTO.setCreateTime(business.getCreateTime());
            businessDTO.setBusinessCode(business.getBusinessCode());
            businessDTO.setStatus(business.getStatus());
            businessDTO.setApiToken(business.getApiToken());
            return businessDTO;
        };
    }

    /**
     * from business 2 businessdto
     *
     * @return
     */
    public static Converter<List<Business>, List<BusinessDTO>> getBusinessListConveter() {

        return businessList -> {
            List<BusinessDTO> businessDTOList = new ArrayList<>();
            for (Business business : businessList) {
                BusinessDTO businessDTO = new BusinessDTO();
                businessDTO.setBusinessName(business.getBusinessName());
                businessDTO.setBusinessId(business.getId());
                businessDTO.setCreateTime(business.getCreateTime());
                businessDTO.setBusinessCode(business.getBusinessCode());
                businessDTO.setStatus(business.getStatus());
                businessDTO.setApiToken(business.getApiToken());
                businessDTOList.add(businessDTO);
            }
            return businessDTOList;
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
