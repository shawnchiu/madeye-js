package cn.rejoicy.madeyecore.application.user;

import cn.rejoicy.madeyecore.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserApplication {


    @Autowired
    private UserService userService;


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


}
