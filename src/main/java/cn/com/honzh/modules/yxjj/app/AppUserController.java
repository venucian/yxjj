package cn.com.honzh.modules.yxjj.app;

import java.util.HashMap;
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
import cn.com.honzh.modules.yxjj.entry.OrderModel;
import cn.com.honzh.modules.yxjj.entry.ResultUtil;
import cn.com.honzh.modules.yxjj.entry.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/app/users")
@Api(tags = "用户相关接口信息")//swagger控制器说明注解
public class AppUserController {
	@Autowired
	IbatisDao ibatisDao;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
  	@Transactional
  	@JsonResult(info=true,message="获取用户信息列表")
    @ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
    @RequestMapping(value = "getUserDetail", method = RequestMethod.POST)
	public Object getUserDetail(HttpServletRequest request, @ApiParam(name="openID",value="openID不能为空",required=true) @RequestParam("openID") Integer openID)  {
		ValidateUtil.notNull(openID, "openID不能为空");
       	ResultUtil resultUtil = new ResultUtil();
       	Map param = new HashMap();
       	param.put("openID", openID);
       	Map map = ibatisDao.load("SYS_USER.getUserList", param);
       	String orderJsonStr = JSONObject.toJSONString(map);
       	UserModel userModel = (UserModel) JSONArray.parseObject(orderJsonStr,UserModel.class);
       	resultUtil.setData(userModel);
   		return resultUtil;
	}

}
