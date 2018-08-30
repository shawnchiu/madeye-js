package cn.rejoicy.madeyecore.infrastructure.log.jpa;

import cn.rejoicy.madeyecore.domain.log.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 日志相关操作 jpa
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface JpaLogRepository extends JpaRepository<Log, Long> {
}
