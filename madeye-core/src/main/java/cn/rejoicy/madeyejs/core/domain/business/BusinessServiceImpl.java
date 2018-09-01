package cn.rejoicy.madeyejs.core.domain.business;

import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.domain.business.enums.BusinessStatusEnum;
import cn.rejoicy.madeyejs.core.infrastructure.business.BusinessRepository;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import cn.rejoicy.madeyejs.core.base.conveter.BusinessConverter;
import cn.rejoicy.madeyejs.core.domain.user.entity.User;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryBusiness;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.List;
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

    @Override
    public Page<Business> findByCondition(ConditionQueryBusiness condition) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(condition.getPage() - 1, condition.getPageSize(), sort);

        return businessRepository.findByCondition((root, query, cb) -> getFullQueryPredicate(condition, root, cb), pageable);
    }


    private Predicate getFullQueryPredicate(ConditionQueryBusiness condition, Root<Business> root, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();

        if (!StringUtils.isEmpty(condition.getBusinessName())) {
            expressions.add(cb.equal(root.<String>get("businessName"), condition.getBusinessName()));
        }
        if (!StringUtils.isEmpty(condition.getUserCode())) {
            ListJoin<Business, User> userJoin = root.joinList("users", JoinType.LEFT);
            expressions.add(userJoin.get("userCode").in(condition.getUserCode()));
        }

        expressions.add(cb.equal(root.<BusinessStatusEnum>get("status"), BusinessStatusEnum.AVAILABLE));
        return predicate;
    }

}
