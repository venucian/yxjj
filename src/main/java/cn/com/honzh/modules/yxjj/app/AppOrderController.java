package cn.com.honzh.modules.yxjj.app;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.honzh.core.annotation.JsonResult;
import cn.com.honzh.core.dao.IbatisDao;
import cn.com.honzh.core.util.ValidateUtil;
import cn.com.honzh.modules.yxjj.entry.OrderModel;
import cn.com.honzh.modules.yxjj.entry.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/app/order")
@Api(tags = "订单相关接口信息")//swagger控制器说明注解
public class AppOrderController {
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
	@ApiOperation(value = "新增订单信息", notes = "新增订单详细信息")
    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    public Object addOrder(@RequestBody OrderModel orderModel) {
		
		if(orderModel.getOrderCode() != null ){
			return ibatisDao.update("YXJJ_ORDER.update", orderModel);
		}
		Double random = Math.random();
		String string = random.toString();
		String randomStr = string.substring(2, string.length());
		Format format = new SimpleDateFormat("yyyyMMddHHmmss");
		String nowStr = format.format(new Date());
		String orderCode = nowStr
				+ randomStr.substring(0, randomStr.length() - 2);
		orderModel.setOrderCode(orderCode);
		return ibatisDao.insert("YXJJ_ORDER.insert", orderModel);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
  	@Transactional
  	@JsonResult(info=true,message="获取订单信息列表")
    @ApiOperation(value = "获取订单信息列表", notes = "获取订单信息列表")
    @RequestMapping(value = "getOrderList.do", method = RequestMethod.POST)
	public Object getOrderList(HttpServletRequest request, @ApiParam(name="pageNumber",value="页码",required=true) @RequestParam("pageNumber") Integer pageNumber,
			 @ApiParam(name="pageSize",value="每页数量",required=true) @RequestParam("pageSize")  Integer pageSize,
			 @ApiParam(name="openID",value="openID",required=true) @RequestParam("openID")  String openID) {
		
		ResultUtil resultUtil = new ResultUtil();
		ValidateUtil.notNull(pageNumber, "pageNumber不能为空");
		ValidateUtil.notNull(pageSize, "pageSize不能为空");
		Map param = new HashMap();
		param.put("pageNumber", ((pageNumber-1)*pageSize<0?0:(pageNumber-1)*pageSize));
		param.put("pageSize", pageSize);
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		List<Map> tempList = ibatisDao.queryForList("YXJJ_ORDER.getOrderList", param);
		for (Map orderMap : tempList) {
			String orderJsonStr = JSONObject.toJSONString(orderMap);
			//TODO待测试看是否可不在循环里创建对象
			OrderModel orderModel = new OrderModel();
			orderModel = (OrderModel) JSONArray.parseObject(orderJsonStr,OrderModel.class);
			orderList.add(orderModel);
		}
		resultUtil.setData(orderList);
		return resultUtil;
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
   	@Transactional
 	@JsonResult(info=true,message="获取订单信息详情")
    @ApiOperation(value = "获取订单信息详情", notes = "获取订单信息详情")
    @RequestMapping(value = "getOrderDetail.do", method = RequestMethod.POST)
   	public ResultUtil getOrderDetail(HttpServletRequest request, @ApiParam(name="id",value="id不能为空",required=true) @RequestParam("id") Integer id) {
   		ValidateUtil.notNull(id, "订单id不能为空");
       	ResultUtil resultUtil = new ResultUtil();
       	Map param = new HashMap();
       	param.put("id", id);
       	Map map = ibatisDao.load("YXJJ_ORDER.getOrderList", param);
       	String orderJsonStr = JSONObject.toJSONString(map);
       	OrderModel orderModel = (OrderModel) JSONArray.parseObject(orderJsonStr,OrderModel.class);
       	resultUtil.setData(orderModel);
   		return resultUtil;
   	}

}
