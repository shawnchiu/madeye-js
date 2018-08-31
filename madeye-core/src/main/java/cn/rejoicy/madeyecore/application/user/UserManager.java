package cn.rejoicy.madeyecore.application.user;

import cn.rejoicy.madeyecore.base.conveter.UserConverter;
import cn.rejoicy.madeyecore.domain.user.UserService;
import cn.rejoicy.madeyecore.domain.user.entity.User;
import cn.rejoicy.madeyecore.viewmodel.LoginInfo;
import cn.rejoicy.madeyecore.viewmodel.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author shawn
 */
@Service
public class UserManager {


    private final UserService userService;

    @Autowired
    public UserManager(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据用户名查询
     * @param userName
     * @return
     * @throws Exception
     */
    public UserDTO findByUserName(String userName) throws Exception {
        User user = userService.findByUserName(userName);
        if (user == null) {
            throw new Exception("用户不存在");
        }
        return UserConverter.getUserConverter().convert(user);
    }


    /**
     * 用户注册
     *
     * @param userName
     * @param password
     * @throws Exception
     */
    public void register(String userName, String password) throws Exception {
        if (StringUtils.isEmpty(userName)) {
            throw new Exception("用户名不能为空");
        }

        if (StringUtils.isEmpty(password)) {
            throw new Exception("密码不能为空");
        }
        userService.register(userName, password);
    }


    /**
     * 修改密码
     *
     * @param userCode
     * @param password
     * @param newPassword
     * @throws Exception
     */
    public void passwordModify(String userCode, String password, String newPassword) throws Exception {

        if (StringUtils.isEmpty(userCode)) {
            throw new Exception("用户不能为空");
        }

        if (StringUtils.isEmpty(password)) {
            throw new Exception("原密码不能为空");
        }

        if (StringUtils.isEmpty(newPassword)) {
            throw new Exception("新密码不能为空");
        }

        userService.passwordModify(userCode, password, newPassword);
    }

    /**
     * 删除用户
     *
     * @param userCode
     * @throws Exception
     */
    public void delete(String userCode) throws Exception {
        userService.delete(userCode);
    }


    /**
     * 用户登陆
     *
     * @param userName
     * @param password
     * @return
     */
    public LoginInfo doLogin(String userName, String password) {
        return new LoginInfo();
    }


}
