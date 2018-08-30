package cn.rejoicy.madeyecore.infrastructure.user;

import cn.rejoicy.madeyecore.domain.user.entity.User;

/**
 * 用户相关操作
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface UserRepository {

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 删除用户
     *
     * @param userCode
     */
    void delete(String userCode);
}
