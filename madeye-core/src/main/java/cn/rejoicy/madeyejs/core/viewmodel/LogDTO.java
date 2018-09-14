package cn.rejoicy.madeyejs.core.viewmodel;

import cn.rejoicy.madeyejs.core.domain.log.enums.LogLevelEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogDTO {

    /**
     * Code
     */
    private String logCode;

    /**
     * 错误级别
     */
    private LogLevelEnum level;

    /**
     * apiToken
     */
    private String apiToken ;

    /**
     * 环境
     */
    private String env;

    /**
     * 消息
     */
    private String message;

    /**
     * 错误链接
     */
    private String url;

    /**
     * 错误页面
     */
    private String page;

    /**
     * host
     */
    private String hostName;

    /**
     * cookie
     */
    private String cookieStr;

    /**
     * 头信息
     */
    private String headerStr;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 错误码
     */
    private String status;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LogLevelEnum getLevel() {
        return level;
    }

    public void setLevel(LogLevelEnum level) {
        this.level = level;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getCookieStr() {
        return cookieStr;
    }

    public void setCookieStr(String cookieStr) {
        this.cookieStr = cookieStr;
    }

    public String getHeaderStr() {
        return headerStr;
    }

    public void setHeaderStr(String headerStr) {
        this.headerStr = headerStr;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
