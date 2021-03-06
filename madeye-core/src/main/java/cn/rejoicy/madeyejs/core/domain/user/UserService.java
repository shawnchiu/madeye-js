package cn.rejoicy.madeyejs.core.domain.user;

import cn.rejoicy.madeyejs.core.domain.user.entity.User;

/**
 * 用户操作类
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param userName
     * @param password
     */
    void register(String userName, String password) throws Exception;

    /**
     * 修改用户密码
     *
     * @param userCode
     * @param password
     * @param newPassword
     */
    void passwordModify(String userCode, String password, String newPassword) throws Exception;

    /**
     * 删除用户
     *
     * @param userCode 用户编码
     */
    void delete(String userCode) throws Exception;

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
