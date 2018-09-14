package cn.rejoicy.madeyejs.core.infrastructure.business;

import cn.rejoicy.madeyejs.core.infrastructure.business.jpa.JpaBusinessRepository;
import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Repository
public class BusinessRepositoryImpl implements BusinessRepository {

    private final JpaBusinessRepository jpaBusinessRepository;

    @Autowired
    public BusinessRepositoryImpl(JpaBusinessRepository jpaBusinessRepository) {
        this.jpaBusinessRepository = jpaBusinessRepository;
    }

    @Override
    public void save(Business business) {
        jpaBusinessRepository.save(business);
    }

    @Override
    public void delete(Business business) {
        jpaBusinessRepository.delete(business);
    }

    @Override
    public Business findByBusinessCode(String businessCode) {
        return jpaBusinessRepository.findByBusinessCode(businessCode);
    }

    @Override
    public Business findByBusinessName(String businessName) {
        return jpaBusinessRepository.findOneByBusinessName(businessName);
    }

    @Override
    public Business findByApiToken(String apiToken) {
        return jpaBusinessRepository.findOneByApiToken(apiToken);
    }

    @Override
    public Page<Business> findByCondition(Specification<Business> specification, Pageable pageable) {
        return jpaBusinessRepository.findAll(specification, pageable);
    }

    @Override
    public List<Business> findAll() {
        return jpaBusinessRepository.findAll();
    }

}
