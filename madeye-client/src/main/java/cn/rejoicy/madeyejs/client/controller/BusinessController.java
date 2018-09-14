package cn.rejoicy.madeyejs.client.controller;

import cn.rejoicy.madeyejs.core.application.business.BusinessManager;
import cn.rejoicy.madeyejs.core.base.ResponseResult;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import cn.rejoicy.madeyejs.core.viewmodel.ConditionQueryBusiness;
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
    @RequestMapping(value = "/addBusiness", method = RequestMethod.POST)
    public ResponseResult addBusiness(@RequestBody BusinessDTO businessDTO) {
        ResponseResult responseResult = new ResponseResult();
        try {
            businessManager.add(businessDTO);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseResult findAll() {
        ResponseResult responseResult = new ResponseResult();
        try {
            responseResult.setResult(businessManager.findAll());
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }

    /**
     * 删除业务
     *
     * @param businessCode
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseResult delete(@RequestParam String businessCode) {
        ResponseResult responseResult = new ResponseResult();
        try {
            businessManager.delete(businessCode);
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }

    /**
     * 根据条件查询业务
     *
     * @param condition
     * @return
     */
    @RequestMapping(value = "/findByCondition", method = RequestMethod.POST)
    public ResponseResult findByCondition(@RequestBody ConditionQueryBusiness condition) {
        ResponseResult responseResult = new ResponseResult();
        try {
            responseResult.setResult(businessManager.findByCondition(condition));
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }
}
