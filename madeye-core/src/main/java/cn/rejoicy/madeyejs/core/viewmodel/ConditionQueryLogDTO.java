package cn.rejoicy.madeyejs.core.viewmodel;

import cn.rejoicy.madeyejs.core.domain.log.enums.LogLevelEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.logging.LogLevel;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * 日志查询条件1
 *
 * @author shawnchiu
 * @date 2018/8/30
 */
public class ConditionQueryLogDTO {

    /**
     * 开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 级别
     */
    private List<LogLevelEnum> logLevel;

    /**
     * 环境
     */
    private String env;

    /**
     * 业务编号
     */
    private String businessCode;

    private int page = 1;

    private int pageSize = 10;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<LogLevelEnum> getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(List<LogLevelEnum> logLevel) {
        this.logLevel = logLevel;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
