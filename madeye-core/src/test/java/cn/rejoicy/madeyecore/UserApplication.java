package cn.rejoicy.madeyecore;

import cn.rejoicy.madeyecore.application.user.UserManager;
import cn.rejoicy.madeyecore.viewmodel.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class UserApplication {

    @Autowired
    private UserManager userManager;

    @Test
    public void register() throws Exception {
        userManager.register("邱小亮", "123456");
    }

    @Test
    public void findByUserName() throws Exception {
        userManager.findByUserName("邱小亮");
    }

    @Test
    public void passwordModify() throws Exception {
        UserDTO userDTO = userManager.findByUserName("邱小亮");
        userManager.passwordModify(userDTO.getUserCode(), "123456", "222222");
    }

}
