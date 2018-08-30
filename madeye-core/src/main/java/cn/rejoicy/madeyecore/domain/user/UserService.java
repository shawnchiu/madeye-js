package cn.rejoicy.madeyecore.domain.user;

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
    void register(String userName, String password);

    /**
     * 删除用户
     * @param userId 用户ID
     */
    void delete(Long userId);
}
