package cn.rejoicy.madeyecore.infrastructure.user;

import cn.rejoicy.madeyecore.domain.user.entity.User;
import cn.rejoicy.madeyecore.infrastructure.user.jpa.JpaUserRepository;
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
}
