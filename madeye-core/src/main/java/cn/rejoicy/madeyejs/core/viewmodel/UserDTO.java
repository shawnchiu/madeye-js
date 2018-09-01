package cn.rejoicy.madeyejs.core.viewmodel;

import java.io.Serializable;

/**
 * 用户
 * @author shawnchiu
 * @date 2018/8/30
 */
public class UserDTO implements Serializable {

    private String userName;

    private String userCode;

    private String email;

    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
