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
import cn.com.honzh.modules.yxjj.entry.DataModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/data")
@Api(value = "数据字典相关服务接口")//swagger控制器说明注解
public class DataDictionaryController {

	@Autowired
	IbatisDao ibatisDao;

	    @SuppressWarnings({ "rawtypes", "unchecked" })
		@ApiOperation(value = "新增用户信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	    @RequestMapping(value = "addDictionary", method = RequestMethod.POST)
	    public Object addDictionary(@RequestBody DataModel dataModel) {
		 if(dataModel.getId() != null){
				return ibatisDao.update("YXJJ_DATA_DICTIONARY.update", dataModel);
			}
			//查看该账号是否已录入
			Map tem = new HashMap();
			tem.put("dataName", dataModel.getDataName());
			tem.put("dataCode", dataModel.getDataCode());
			Map map = ibatisDao.load("YXJJ_DATA_DICTIONARY.getDataList", tem);
			if(map != null){
				throw new BusinessException(dataModel.getDataName(), "已在列表中");
			}
			return ibatisDao.insert("YXJJ_DATA_DICTIONARY.insert", dataModel);
	    }
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		@Transactional
		@JsonResult(info=true,message="删除成功")
	    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
	    @RequestMapping(value = "deleteDictionary", method = RequestMethod.POST)
		public Object deleteDictionary(HttpServletRequest request, Map param) {
	    	ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
			List<Integer> ids = (List<Integer>) param.get("ids");
			Map tem = new HashMap();
			for(Integer id : ids){
				tem.put("id", id);
				tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
				tem.put("deleteDate",new Date());
				ibatisDao.update("YXJJ_DATA_DICTIONARY.deleteByID", tem);
			}
			return true;
		}
	    
	    @SuppressWarnings( "rawtypes" )
	  	@Transactional
	  	@JsonResult(info=true,message="获取列表成功")
	    @ApiOperation(value = "获取数据字典列表", notes = "获取数据字典列表")
	    @RequestMapping(value = "getDictionaryList", method = RequestMethod.GET)
		public Object getDictionaryList(HttpServletRequest request, Map param) {
	    	ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
			ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
			return ibatisDao.pageQuery("YXJJ_DATA_DICTIONARY.getDataList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
		}
}
