package cn.rejoicy.madeyejs.core.viewmodel;

/**
 * 登陆信息
 *
 * @author shawnchiu
 * @date 2018/8/31
 */
public class LoginInfo {

    private String userName;

    private String authToken;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
