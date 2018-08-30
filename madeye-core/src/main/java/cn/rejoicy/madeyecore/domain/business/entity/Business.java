package cn.rejoicy.madeyecore.domain.business.entity;

import cn.rejoicy.madeyecore.base.entity.BaseEntity;
import cn.rejoicy.madeyecore.domain.business.enums.BusinessStatusEnum;

import javax.persistence.*;

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
    private String businessCode;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 业务状态
     */
    private BusinessStatusEnum status;

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
}
