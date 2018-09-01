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

    /**
     * 查询所有业务
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseResult findAll(@RequestParam int page, @RequestParam int pageSize) {
        ResponseResult responseResult = new ResponseResult();
        try {
            ConditionQueryBusiness conditionQueryBusiness = new ConditionQueryBusiness();
            conditionQueryBusiness.setPage(page);
            conditionQueryBusiness.setPageSize(pageSize);
            responseResult.setResult(businessManager.findByCondition(conditionQueryBusiness));
        } catch (Exception e) {
            responseResult.putException(e);
        }
        return responseResult;
    }
}
