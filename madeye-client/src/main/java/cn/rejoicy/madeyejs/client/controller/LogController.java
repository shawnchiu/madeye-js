package cn.rejoicy.madeyejs.client.controller;

import cn.rejoicy.madeyejs.core.application.log.LogManager;
import cn.rejoicy.madeyejs.core.base.ResponseResult;
import cn.rejoicy.madeyejs.core.domain.log.enums.LogLevelEnum;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryLogDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */

@Controller
@RestController
@RequestMapping(value = "/api/log")
@CrossOrigin("*")
public class LogController {
    private final LogManager logManager;

    @Autowired
    public LogController(LogManager logManager) {
        this.logManager = logManager;
    }

    /**
     * 创建日志
     *
     * @param logDTO
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseResult create(@RequestBody LogDTO logDTO) {
        ResponseResult responseResult = new ResponseResult();
        try {
            logManager.create(logDTO);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }

    /**
     * 记录错误日志
     *
     * @return
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseResult error(HttpServletRequest request) {
        ResponseResult responseResult = new ResponseResult();
        try {
            LogDTO logDTO = new LogDTO();
            logDTO.setStatus(request.getParameter("status"));
            logDTO.setApiToken(request.getParameter("apiToken"));
            logDTO.setBrowser(request.getParameter("browser"));
            logDTO.setMessage(request.getParameter("message"));
            logDTO.setEnv(request.getParameter("env"));
            logDTO.setLevel(LogLevelEnum.ERROR);
            logManager.create(logDTO);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }

    /**
     * 创建日志
     *
     * @param condition
     * @return
     */
    @RequestMapping(value = "/findByCondition", method = RequestMethod.POST)
    public ResponseResult findByCondition(@RequestBody ConditionQueryLogDTO condition) {
        ResponseResult responseResult = new ResponseResult();
        try {
            Page<LogDTO> logDTOS = logManager.findByCondition(condition);
            responseResult.setResult(logDTOS);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }


}
