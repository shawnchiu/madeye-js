package cn.rejoicy.madeyejs.client.controller;

import cn.rejoicy.madeyejs.core.application.business.BusinessManager;
import cn.rejoicy.madeyejs.core.base.ResponseResult;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */
@Controller
@RestController
@RequestMapping(value = "/api/business")
@CrossOrigin("*")
public class BusinessController {

    private final BusinessManager businessManager;

    @Autowired
    public BusinessController(BusinessManager businessManager) {
        this.businessManager = businessManager;
    }

    /**
     * 添加业务
     *
     * @param businessDTO
     * @return
     */
    @RequestMapping(value = "addBusiness", method = RequestMethod.POST)
    public ResponseResult addBusiness(@RequestBody BusinessDTO businessDTO) {
        ResponseResult responseResult = new ResponseResult();
        try {
            businessManager.add(businessDTO);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }
}
