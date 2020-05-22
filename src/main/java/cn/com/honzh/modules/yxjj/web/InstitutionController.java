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
import cn.com.honzh.modules.yxjj.entry.InstitutionModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/institution")
@Api(value = "机构相关服务接口")//swagger控制器说明注解
public class InstitutionController {
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
    public Object addApplyer(@RequestBody  InstitutionModel institutionModel) {
    	if(institutionModel.getId() != null){
			return ibatisDao.update("YXJJ_EDU_INSTITUTION.update", institutionModel);
		}
		//查看该账号是否已录入
		Map tem = new HashMap();
		tem.put("institutionName", institutionModel.getInstitutionName());
		Map map = ibatisDao.load("YXJJ_EDU_INSTITUTION.getInstitutionList", tem);
		if(map != null){
			throw new BusinessException(institutionModel.getInstitutionName(), "该机构或院校已申请入驻");
		}
		return ibatisDao.insert("YXJJ_EDU_INSTITUTION.insert", institutionModel);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@JsonResult(info=true,message="删除成功")
    @ApiOperation(value = "删除机构列表信息", notes = "删除机构列表信息")
    @RequestMapping(value = "deleteInstitution", method = RequestMethod.POST)
	public Object deleteInstitution(HttpServletRequest request, Map param) {
    	ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
		List<Integer> ids = (List<Integer>) param.get("ids");
		Map tem = new HashMap();
		for(Integer id : ids){
			tem.put("id", id);
			tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
			tem.put("deleteDate",new Date());
			ibatisDao.update("YXJJ_EDU_INSTITUTION.deleteByID", tem);
		}
		return true;
	}
    
    @SuppressWarnings("rawtypes")
  	@Transactional
  	@JsonResult(info=true,message="获取机构列表信息")
    @ApiOperation(value = "获取机构列表信息", notes = "获取机构列表信息")
    @RequestMapping(value = "getInstitutionList", method = RequestMethod.GET)
	public Object getInstitutionList(HttpServletRequest request, Map param) {
    	ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
		ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
		return ibatisDao.pageQuery("YXJJ_EDU_INSTITUTION.getInstitutionList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
	}

}
