package cn.rejoicy.madeyecore.infrastructure.user.jpa;

import cn.rejoicy.madeyecore.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface JpaUserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户编码删除用户信息
     *
     * @param userCode
     */
    void deleteByUserCode(String userCode);
}