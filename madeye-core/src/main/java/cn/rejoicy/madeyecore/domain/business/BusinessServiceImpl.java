package cn.rejoicy.madeyecore.domain.business;

import cn.rejoicy.madeyecore.domain.business.enums.BusinessStatusEnum;
import cn.rejoicy.madeyecore.viewmodel.BusinessDTO;
import org.springframework.stereotype.Service;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Override
    public void add(BusinessDTO businessDTO) {

    }

    @Override
    public void updateStatus(String businessCode, BusinessStatusEnum status) {

    }

    @Override
    public void delete(String businessCode) {

    }
}
