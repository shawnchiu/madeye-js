package cn.rejoicy.madeyecore.domain.user;

import cn.rejoicy.madeyecore.domain.user.entity.User;
import cn.rejoicy.madeyecore.infrastructure.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 用户操作类
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String userName, String password) throws Exception {

        if (StringUtils.isEmpty(userName)) {
            throw new Exception("用户名不能为空");
        }

        if (StringUtils.isEmpty(password)) {
            throw new Exception("密码不能为空");
        }

        User user = userRepository.findByUserName(userName);

        if (user != null) {
            throw new Exception("用户名已被注册");
        }

        User userCreate = new User();
        userCreate.setUserName(userName);
        userCreate.setUserCode(UUID.randomUUID().toString());
        userCreate.setPassword(password);

        userRepository.save(userCreate);
    }

    @Override
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

        User user = userRepository.findByUserCode(userCode);

        if (user == null) {
            throw new Exception("用户信息不存在");
        }

        if (!newPassword.equals(user.getPassword())) {
            throw new Exception("密码验证失败");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    @Override
    public void delete(String userCode) throws Exception {
        User user = userRepository.findByUserCode(userCode);
        if (user == null) {
            throw new Exception("用户信息不存在");
        }

        userRepository.delete(userCode);
    }
}
