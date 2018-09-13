package cn.rejoicy.madeyejs.client.controller;

import cn.rejoicy.madeyejs.core.application.log.LogManager;
import cn.rejoicy.madeyejs.core.base.ResponseResult;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult addBusiness(@RequestBody LogDTO logDTO) {
        ResponseResult responseResult = new ResponseResult();
        try {
            logManager.create(logDTO);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }


}
