package cn.rejoicy.madeyejs.core.viewmodel;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */
public class ConditionQueryBusiness {

    private String businessName;

    private String userCode;

    private int page;

    private int pageSize;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
