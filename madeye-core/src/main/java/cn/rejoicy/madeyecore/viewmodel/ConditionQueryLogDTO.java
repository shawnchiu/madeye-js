package cn.rejoicy.madeyecore.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.logging.LogLevel;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
     * 日志等级
     */
    private LogLevel level;

    /**
     * 环境
     */
    private String env;
}
