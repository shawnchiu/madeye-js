package cn.rejoicy.madeyejs.core.infrastructure.user;

import cn.rejoicy.madeyejs.core.infrastructure.user.jpa.JpaUserRepository;
import cn.rejoicy.madeyejs.core.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public void delete(String userCode) {
        jpaUserRepository.deleteByUserCode(userCode);
    }

    @Override
    public User findByUserName(String userName) {
        return jpaUserRepository.findByUserName(userName);
    }

    @Override
    public User findByUserCode(String userCode) {
        return jpaUserRepository.findByUserCode(userCode);
    }
}
