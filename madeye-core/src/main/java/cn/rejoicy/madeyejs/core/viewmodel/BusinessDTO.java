package cn.rejoicy.madeyejs.core.viewmodel;

import cn.rejoicy.madeyejs.core.domain.business.enums.BusinessStatusEnum;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
public class BusinessDTO {

    private String businessName;

    private String businessCode;

    private BusinessStatusEnum status;

    private String apiToken;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
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
}
