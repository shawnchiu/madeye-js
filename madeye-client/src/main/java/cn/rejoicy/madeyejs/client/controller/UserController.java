package cn.rejoicy.madeyejs.client.controller;

import cn.rejoicy.madeyejs.core.application.user.UserManager;
import cn.rejoicy.madeyejs.core.base.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */

@Controller
@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * 用户注册
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseResult addBusiness(@RequestParam String userName, @RequestParam String password) {
        ResponseResult responseResult = new ResponseResult();
        try {
            userManager.register(userName, password);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }
}

