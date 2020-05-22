package cn.com.honzh.modules.yxjj.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.honzh.core.AresR;
import cn.com.honzh.core.annotation.JsonResult;
import cn.com.honzh.core.dao.IbatisDao;
import cn.com.honzh.core.ex.BusinessException;
import cn.com.honzh.core.util.ValidateUtil;
import cn.com.honzh.modules.yxjj.entry.ApplyerModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/applyer")
@Api(value = "用户相关服务接口")//swagger控制器说明注解
public class ApplyController {
	@Autowired
	IbatisDao ibatisDao;

	   /**
     * * 入参是对象,使用默认参数paramType = "body"
     * ApiIgnore()用于类，方法，方法参数
     * 表示这个方法或者类被忽略,不被显示在swagger页面上
     * @param resp
     * @param id
     * @param user
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "新增申请者信息", notes = "新增申请者信息")
    @RequestMapping(value = "addApplyer", method = RequestMethod.POST)
    public Object addApplyer(@RequestBody  ApplyerModel applyerModel) {
    	if(applyerModel.getId() != null){
			return ibatisDao.update("YXJJ_APPLY.update", applyerModel);
		}
		//查看该账号是否已录入
		Map tem = new HashMap();
		tem.put("orgName", applyerModel.getOrgName());
		Map map = ibatisDao.load("YXJJ_APPLY.getApplyerList", tem);
		if(map != null){
			throw new BusinessException(applyerModel.getOrgName(), "该机构或院校已申请入驻");
		}
		return ibatisDao.insert("YXJJ_APPLY.insert", applyerModel);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@JsonResult(info=true,message="删除成功")
    @ApiOperation(value = "删除申请者信息", notes = "删除申请者信息")
    @RequestMapping(value = "deleteApplyer", method = RequestMethod.POST)
	public Object deleteApplyer(HttpServletRequest request, Map param) {
    	ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
		List<Integer> ids = (List<Integer>) param.get("ids");
		Map tem = new HashMap();
		for(Integer id : ids){
			tem.put("id", id);
			tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
			tem.put("deleteDate",new Date());
			ibatisDao.update("YXJJ_APPLY.deleteByID", tem);
		}
		return true;
	}
    
    @SuppressWarnings("rawtypes")
  	@Transactional
  	@JsonResult(info=true,message="获取申请者列表信息")
    @ApiOperation(value = "获取申请者列表信息", notes = "获取申请者列表信息")
    @RequestMapping(value = "getApplyerList", method = RequestMethod.GET)
	public Object getApplyerList(HttpServletRequest request, Map param) {
    	ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
		ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
		return ibatisDao.pageQuery("YXJJ_APPLY.getApplyerList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
	}

}
