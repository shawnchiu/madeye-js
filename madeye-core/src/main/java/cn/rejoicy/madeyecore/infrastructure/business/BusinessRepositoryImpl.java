package cn.rejoicy.madeyecore.infrastructure.business;

import cn.rejoicy.madeyecore.domain.business.entity.Business;
import cn.rejoicy.madeyecore.infrastructure.business.jpa.JpaBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Repository
public class BusinessRepositoryImpl  implements BusinessRepository{

    @Autowired
    private JpaBusinessRepository jpaBusinessRepository;

    @Override
    public Business save(Business business) {
        return jpaBusinessRepository.save(business);
    }

    @Override
    public void delete(Business business) {
        jpaBusinessRepository.delete(business);
    }
}
