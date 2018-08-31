package cn.rejoicy.madeyecore.domain.user.entity;

import cn.rejoicy.madeyecore.base.entity.BaseEntity;
import cn.rejoicy.madeyecore.domain.business.entity.Business;
import cn.rejoicy.madeyecore.domain.user.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * 用户
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Entity
@Table(name = "tb_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_id", nullable = false)
    private Long id;

    /**
     * 用户名
     */
    @Column(length = 50, nullable = false, unique = true)
    private String userName;

    /**
     * 用户编码
     */
    @Column(length = 32, unique = true, updatable = false)
    private String userCode;

    /**
     * 密码
     */
    // TODO: 2018/8/31 数据库中加密
    @Column(length = 256, nullable = false)
    private String password;

    /**
     * 手机号
     */
    @Column(length = 20, unique = true)
    private String phone;

    /**
     * 电子邮箱
     */
    @Column(length = 50, unique = true)
    private String email;

    /**
     * 用户类型
     */
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Business> businesses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}
