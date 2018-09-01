package cn.rejoicy.madeyejs.core.infrastructure.user;

import cn.rejoicy.madeyejs.core.domain.user.entity.User;

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

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据用户编码查询用户信息
     *
     * @param userCode
     * @return
     */
    User findByUserCode(String userCode);
}
