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
import cn.com.honzh.modules.yxjj.entry.GoodsModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/goods")
@Api(value = "商品相关服务接口")//swagger控制器说明注解
public class GoodsController {
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
	@ApiOperation(value = "新增商品信息", notes = "新增商品详细信息")
    @RequestMapping(value = "addGoods", method = RequestMethod.POST)
    public Object addGoods(@RequestBody GoodsModel goodsModel) {
		
		if(goodsModel.getId() != null){
			return ibatisDao.update("YXJJ_GOODS.update", goodsModel);
		}
	
		return ibatisDao.insert("YXJJ_GOODS.insert", goodsModel);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@JsonResult(info=true,message="删除成功")
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @RequestMapping(value = "deleteGoods", method = RequestMethod.POST)
	public Object deleteGoods(HttpServletRequest request, Map param) {
		ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
		List<Integer> ids = (List<Integer>) param.get("ids");
		Map tem = new HashMap();
		for(Integer id : ids){
			tem.put("id", id);
			tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
			tem.put("deleteDate",new Date());
			ibatisDao.update("YXJJ_GOODS.deleteByID", tem);
		}
		return true;
	}
    
    @SuppressWarnings("rawtypes")
  	@Transactional
  	@JsonResult(info=true,message="获取用户信息列表")
    @ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
    @RequestMapping(value = "getGoodsList", method = RequestMethod.GET)
	public Object getGoodsList(HttpServletRequest request, Map param) {
		ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
		ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
		return ibatisDao.pageQuery("YXJJ_GOODS.getGoodsList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
	}

}
