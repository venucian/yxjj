package cn.com.honzh.modules.yxjj.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.honzh.core.annotation.JsonResult;
import cn.com.honzh.core.dao.IbatisDao;
import cn.com.honzh.core.util.ValidateUtil;
import cn.com.honzh.modules.yxjj.entry.RecordModel;
import cn.com.honzh.modules.yxjj.entry.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/app/record")
@Api(tags = "签到相关接口信息")//swagger控制器说明注解
public class AppRecordController {
	@Autowired
	IbatisDao ibatisDao;

	@ApiOperation(value = "新增签到信息", notes = "新增签到信息")
    @RequestMapping(value = "addRecords", method = RequestMethod.POST)
    public Object addRecords(@RequestBody RecordModel recordModel) {
		
		if(recordModel.getId() != null){
			return ibatisDao.update("SIGN_RECORD.update", recordModel);
		}
	
		return ibatisDao.insert("SIGN_RECORD.insert", recordModel);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
  	@Transactional
  	@JsonResult(info=true,message="获取签到信息列表")
    @ApiOperation(value = "获取签到信息列表", notes = "获取签到信息列表")
    @RequestMapping(value = "getRecordsList", method = RequestMethod.POST)
	public Object getRecordsList(HttpServletRequest request, @ApiParam(name="pageNumber",value="页码",required=true) @RequestParam("pageNumber") Integer pageNumber,
			 @ApiParam(name="pageSize",value="每页数量",required=true) @RequestParam("pageSize")  Integer pageSize) {

		ResultUtil resultUtil = new ResultUtil();
		ValidateUtil.notNull(pageNumber, "pageNumber不能为空");
		ValidateUtil.notNull(pageSize, "pageSize不能为空");
		Map param = new HashMap();
		param.put("pageNumber", ((pageNumber-1)*pageSize<0?0:(pageNumber-1)*pageSize));
		param.put("pageSize", pageSize);
		List<RecordModel> recordList = new ArrayList<RecordModel>();
		List<Map> tempList = ibatisDao.queryForList("SIGN_RECORD.getRecordsList", param);
		for (Map orderMap : tempList) {
			String orderJsonStr = JSONObject.toJSONString(orderMap);
			//TODO待测试看是否可不在循环里创建对象
			RecordModel recordModel = new RecordModel();
			recordModel = (RecordModel) JSONArray.parseObject(orderJsonStr,RecordModel.class);
			recordList.add(recordModel);
		}
		resultUtil.setData(recordList);
		return resultUtil;
	}

}
