package cn.rejoicy.madeyejs.core.domain.log.entity;

import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.base.entity.BaseEntity;
import cn.rejoicy.madeyejs.core.domain.log.enums.LogLevelEnum;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author shawnchiu
 * @date 2018/8/30
 */
@Entity
@Table(name = "tb_log")
public class Log extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_id", nullable = false)
    private Long id;

    /**
     * 日志编码
     */
    @Column(length = 32, unique = true, updatable = false)
    private String logCode;

    /**
     * 错误级别
     */
    @Enumerated(EnumType.STRING)
    private LogLevelEnum level;

    /**
     * 所属业务
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="businessCode")
    private Business business;

    /**
     * 环境 (用于区分生产环境和测试环境)
     */
    @Column(length = 30)
    private String env;

    /**
     * 消息
     */
    @Column(length = 500)
    private String message;

    /**
     * 错误链接
     */
    @Column(length = 500)
    private String url;

    /**
     * 错误页面
     */
    @Column(length = 500)
    private String page;

    /**
     * host
     */
    @Column(length = 100)
    private String hostName;

    /**
     * cookie
     */
    @Column(length = 1000)
    private String cookieStr;

    /**
     * 浏览器
     */
    @Column(length = 100)
    private String browser;

    /**
     * 头信息
     */
    @Column(length = 1000)
    private String headerStr;

    /**
     * 错误码
     */
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public LogLevelEnum getLevel() {
        return level;
    }

    public void setLevel(LogLevelEnum level) {
        this.level = level;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
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

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Override
    public void preUpdate() {
        if(StringUtils.isEmpty(logCode)){
            logCode = UUID.randomUUID().toString().replace("-", "");
        }
        super.preUpdate();
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", logCode='" + logCode + '\'' +
                ", level=" + level +
                ", business=" + business +
                ", browser='" + browser  + '\'' +
                ", env='" + env + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", page='" + page + '\'' +
                ", hostName='" + hostName + '\'' +
                ", cookieStr='" + cookieStr + '\'' +
                ", headerStr='" + headerStr + '\'' +
                '}';
    }
}
