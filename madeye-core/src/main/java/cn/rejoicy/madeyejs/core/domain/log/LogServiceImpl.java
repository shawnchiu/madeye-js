package cn.rejoicy.madeyejs.core.domain.log;

import cn.rejoicy.madeyejs.core.base.conveter.LogConverter;
import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.domain.log.enums.LogLevelEnum;
import cn.rejoicy.madeyejs.core.infrastructure.log.LogRepository;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 日志相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Service
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log preCreate(LogDTO logDTO, Business business) {
        Log log = LogConverter.getLogDTOConveter().convert(logDTO);
        log.setLogCode(UUID.randomUUID().toString().replace("-", ""));
        log.setBusiness(business);
        log.setCreateTime(new Date());
        return log;
    }

    @Override
    public Log create(Log log) {
        return logRepository.save(log);
    }

    @Override
    public void delete(String logCode) {
        Log log = logRepository.findByLogCode(logCode);
        if (log == null) {
            return;
        }
        logRepository.delete(log);
    }

    @Override
    public Page<Log> findByCondition(ConditionQueryLogDTO condition) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(condition.getPage() - 1, condition.getPageSize(), sort);
        return logRepository.findByCondition((root, query, cb) -> getFullQueryPredicate(condition, root, cb), pageable);
    }

    private Predicate getFullQueryPredicate(ConditionQueryLogDTO condition, Root<Log> root, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();

        if (!StringUtils.isEmpty(condition.getBusinessCode())) {
            Join<Log, Business> businessJoin = root.join(root.getModel().getSingularAttribute("business", Business.class), JoinType.LEFT);
            expressions.add(cb.equal(businessJoin.<String>get("businessCode"), condition.getBusinessCode()));
        }
        if (condition.getLevel() != null) {
            expressions.add(cb.equal(root.<LogLevelEnum>get("level"), condition.getLevel()));
        }
        if (condition.getStartTime() != null) {
            expressions.add(cb.greaterThanOrEqualTo(root.get("createTime"), condition.getStartTime()));
        }
        if (condition.getEndTime() != null) {
            expressions.add(cb.lessThanOrEqualTo(root.get("createTime"), condition.getEndTime()));
        }

        return predicate;
    }
}
