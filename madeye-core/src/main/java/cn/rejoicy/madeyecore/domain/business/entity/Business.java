package cn.rejoicy.madeyecore.domain.business.entity;

import cn.rejoicy.madeyecore.base.entity.BaseEntity;
import cn.rejoicy.madeyecore.domain.business.enums.BusinessStatusEnum;
import cn.rejoicy.madeyecore.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

/**
 * 业务实体
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
@Entity
@Table(name = "tb_business")
public class Business extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_id", nullable = false)
    private Long id;

    /**
     * 业务编码
     */
    @Column(length = 32, unique = true, updatable = false)
    private String businessCode;

    /**
     * 业务名称
     */
    @Column(length = 50)
    private String businessName;

    /**
     * 业务状态
     */
    @Enumerated(EnumType.STRING)
    private BusinessStatusEnum status;

    /**
     * 提交日志所需的token
     */
    @Column(length = 128, unique = true, updatable = false)
    private String apiToken;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_user_business",
            joinColumns = @JoinColumn(name = "user_code"),
            inverseJoinColumns = @JoinColumn(name = "business_code")
    )
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public BusinessStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BusinessStatusEnum status) {
        this.status = status;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
