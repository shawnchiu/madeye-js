package cn.rejoicy.madeyecore.domain.business;

import cn.rejoicy.madeyecore.base.conveter.BusinessConverter;
import cn.rejoicy.madeyecore.domain.business.entity.Business;
import cn.rejoicy.madeyecore.domain.business.enums.BusinessStatusEnum;
import cn.rejoicy.madeyecore.infrastructure.business.BusinessRepository;
import cn.rejoicy.madeyecore.viewmodel.BusinessDTO;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public void add(BusinessDTO businessDTO) throws Exception {
        if (StringUtils.isEmpty(businessDTO.getBusinessName())) {
            throw new Exception("业务名不能为空");
        }

        Business businessQuery = businessRepository.findByBusinessName(businessDTO.getBusinessName());

        if (businessQuery != null) {
            throw new Exception("业务重名");
        }

        Business business = BusinessConverter.getBusinessDTOConveter().convert(businessDTO);
        business.setStatus(BusinessStatusEnum.AVAILABLE);
        business.setBusinessCode(UUID.randomUUID().toString().replace("-", ""));
        business.setApiToken(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        businessRepository.save(business);
    }

    @Override
    public void updateStatus(@NotNull String businessCode, @NotNull BusinessStatusEnum status) throws Exception {
        Business business = businessRepository.findByBusinessCode(businessCode);
        if (business == null) {
            throw new Exception("找不到相关业务");
        }
        if (status.equals(business.getStatus())) {
            return;
        }

        business.setStatus(status);
        businessRepository.save(business);
    }

    @Override
    public void delete(@NotNull String businessCode) {
        Business business = businessRepository.findByBusinessCode(businessCode);
        if (business == null) {
            return;
        }
        businessRepository.delete(business);
    }

    @Override
    public Business findByApiToken(@NotNull String apiToken) {
        return businessRepository.findByApiToken(apiToken);
    }
}
