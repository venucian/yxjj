package cn.com.honzh.modules.yxjj.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.honzh.core.annotation.JsonResult;
import cn.com.honzh.core.dao.IbatisDao;
import cn.com.honzh.core.util.ValidateUtil;
import cn.com.honzh.modules.yxjj.entry.InformationModel;
import cn.com.honzh.modules.yxjj.entry.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/app/institution")
@Api(tags = "资讯相关接口信息")//swagger控制器说明注解
public class AppInformationTextController {
	@Autowired
	IbatisDao ibatisDao;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
  	@Transactional
  	@JsonResult(info=true,message="获取资讯列表信息")
    @ApiOperation(value = "获取资讯列表信息", notes = "获取资讯列表信息")
    @RequestMapping(value = "getInformationList", method = RequestMethod.POST)
	public ResultUtil getInformationList(HttpServletRequest request, @ApiParam(name="pageNumber",value="页码",required=true) @RequestParam("pageNumber") Integer pageNumber,
			 @ApiParam(name="pageSize",value="每页数量",required=true) @RequestParam("pageSize")  Integer pageSize) {
    	ResultUtil resultUtil = new ResultUtil();
		ValidateUtil.notNull(pageNumber, "pageNumber不能为空");
		ValidateUtil.notNull(pageSize, "pageSize不能为空");
		Map param = new HashMap();
		param.put("pageNumber", ((pageNumber-1)*pageSize<0?0:(pageNumber-1)*pageSize));
		param.put("pageSize", pageSize);
		List<InformationModel> informationList = new ArrayList<InformationModel>();
		List<Map> tempList = ibatisDao.queryForList("YXJJ_INFORMATION_TEXT.getInformationList", param);
		for (Map orderMap : tempList) {
			String orderJsonStr = JSONObject.toJSONString(orderMap);
			//TODO待测试看是否可不在循环里创建对象
			InformationModel informationModel = new InformationModel();
			informationModel = (InformationModel) JSONArray.parseObject(orderJsonStr,InformationModel.class);
			informationList.add(informationModel);
		}
		resultUtil.setData(informationList);
		return resultUtil;
	}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
  	@JsonResult(info=true,message="获取资讯信息详情")
    @ApiOperation(value = "获取资讯信息详情", notes = "获取资讯信息详情")
    @RequestMapping(value = "getInformationDetail.do", method = RequestMethod.POST)
	public ResultUtil getInformationDetail(HttpServletRequest request, @ApiParam(name="id",value="id不能为空",required=true) @RequestParam("id") Integer id) {
		ValidateUtil.notNull(id, "资讯id不能为空");
    	ResultUtil resultUtil = new ResultUtil();
    	Map param = new HashMap();
    	param.put("id", id);
    	Map map = ibatisDao.load("YXJJ_INFORMATION_TEXT.getInformationList", param);
    	String orderJsonStr = JSONObject.toJSONString(map);
    	InformationModel informationModel = (InformationModel) JSONArray.parseObject(orderJsonStr,InformationModel.class);
    	resultUtil.setData(informationModel);
		return resultUtil;
	}
}
