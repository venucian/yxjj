package cn.com.honzh.modules.yxjj.web;

import java.text.Format;
import java.text.SimpleDateFormat;
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
import cn.com.honzh.modules.yxjj.entry.OrderModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/order")
@Api(value = "用户相关服务接口")//swagger控制器说明注解
public class OrderController {
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
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@JsonResult(info=true,message="删除成功")
    @ApiOperation(value = "删除订单信息", notes = "删除订单信息")
    @RequestMapping(value = "deleteOrder", method = RequestMethod.POST)
	public Object deleteOrder(HttpServletRequest request, Map param) {
		ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
		List<Integer> ids = (List<Integer>) param.get("ids");
		Map tem = new HashMap();
		for(Integer id : ids){
			tem.put("id", id);
			tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
			tem.put("deleteDate",new Date());
			ibatisDao.update("YXJJ_ORDER.deleteByID", tem);
		}
		return true;
	}
    
    @SuppressWarnings("rawtypes")
  	@Transactional
  	@JsonResult(info=true,message="获取订单信息列表")
    @ApiOperation(value = "获取订单信息列表", notes = "获取订单信息列表")
    @RequestMapping(value = "getOrderList", method = RequestMethod.GET)
	public Object getOrderList(HttpServletRequest request, Map param) {
		ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
		ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
		return ibatisDao.pageQuery("YXJJ_ORDER.getOrderList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
	}

}
