package cn.rejoicy.madeyejs.core.base.conveter;

import cn.rejoicy.madeyejs.core.domain.business.entity.Business;
import cn.rejoicy.madeyejs.core.domain.log.entity.Log;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */
public class LogConverter {


    public static Converter<Log, LogDTO> getLogConverter() {

        return log -> {
            LogDTO logDTO = new LogDTO();
            logDTO.setLogCode(log.getLogCode());
            logDTO.setCookieStr(log.getCookieStr());
            logDTO.setCreateTime(log.getCreateTime());
            logDTO.setEnv(log.getEnv());
            logDTO.setHeaderStr(log.getHeaderStr());
            logDTO.setHostName(log.getHostName());
            logDTO.setPage(log.getPage());
            logDTO.setMessage(log.getMessage());
            logDTO.setUrl(log.getUrl());
            logDTO.setLevel(log.getLevel());
            return logDTO;
        };
    }


    public static Converter<LogDTO, Log> getLogDTOConveter() {

        return logDTO -> {
            Log log = new Log();
            log.setCookieStr(logDTO.getCookieStr());
            log.setCreateTime(logDTO.getCreateTime());
            log.setEnv(logDTO.getEnv());
            log.setHeaderStr(logDTO.getHeaderStr());
            log.setHostName(logDTO.getHostName());
            log.setPage(logDTO.getPage());
            log.setMessage(logDTO.getMessage());
            log.setUrl(logDTO.getUrl());
            log.setLevel(logDTO.getLevel());
            return log;
        };
    }
}
