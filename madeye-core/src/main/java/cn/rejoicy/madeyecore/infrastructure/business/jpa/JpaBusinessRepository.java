package cn.rejoicy.madeyecore.infrastructure.business.jpa;

import cn.rejoicy.madeyecore.domain.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 业务相关操作 jpa
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface JpaBusinessRepository  extends JpaRepository<Business, Long> {
}
