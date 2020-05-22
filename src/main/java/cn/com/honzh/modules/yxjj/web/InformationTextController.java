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
import cn.com.honzh.core.util.ValidateUtil;
import cn.com.honzh.modules.yxjj.entry.InformationModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/institution")
@Api(value = "资讯相关服务接口")//swagger控制器说明注解
public class InformationTextController {
	@Autowired
	IbatisDao ibatisDao;

	@ApiOperation(value = "新增资讯信息", notes = "新增资讯信息")
    @RequestMapping(value = "addInformation", method = RequestMethod.POST)
    public Object addInformation(@RequestBody  InformationModel informationModel) {
    	if(informationModel.getId() != null){
			return ibatisDao.update("YXJJ_INFORMATION_TEXT.update", informationModel);
		}
		return ibatisDao.insert("YXJJ_INFORMATION_TEXT.insert", informationModel);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@JsonResult(info=true,message="删除成功")
    @ApiOperation(value = "删除资讯列表信息", notes = "删除资讯列表信息")
    @RequestMapping(value = "deleteInformation", method = RequestMethod.POST)
	public Object deleteInformation(HttpServletRequest request, Map param) {
    	ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
		List<Integer> ids = (List<Integer>) param.get("ids");
		Map tem = new HashMap();
		for(Integer id : ids){
			tem.put("id", id);
			tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
			tem.put("deleteDate",new Date());
			ibatisDao.update("YXJJ_INFORMATION_TEXT.deleteByID", tem);
		}
		return true;
	}
    
    @SuppressWarnings("rawtypes")
  	@Transactional
  	@JsonResult(info=true,message="获取资讯列表信息")
    @ApiOperation(value = "获取资讯列表信息", notes = "获取资讯列表信息")
    @RequestMapping(value = "getInformationList", method = RequestMethod.GET)
	public Object getInformationList(HttpServletRequest request, Map param) {
    	ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
		ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
		return ibatisDao.pageQuery("YXJJ_INFORMATION_TEXT.getInformationList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
	}

}
