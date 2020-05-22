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
import cn.com.honzh.modules.yxjj.entry.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/web/users")
@Api(value = "用户相关服务接口")//swagger控制器说明注解
public class UserController {
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
	@ApiOperation(value = "新增用户信息", notes = "新增用户详细信息")
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public Object addUser(@RequestBody UserModel userModel) {
    	String regex = "\\d{15}(\\d{2}[0-9xX])?"; 
		if(!userModel.getIdCardNo().matches(regex)){ 
			throw new BusinessException(userModel.getIdCardNo(), "该身份证号不合法");
		}
		
		if(userModel.getId() != null){
			return ibatisDao.update("SYS_USER.update", userModel);
		}
		//查看该账号是否已录入
		Map tem = new HashMap();
		tem.put("idCardNo", userModel.getIdCardNo());
		Map map = ibatisDao.load("SYS_USER.getUserList", tem);
		if(map != null){
			throw new BusinessException(map.get("idCardNo").toString(), "该用户已经存在");
		}
		return ibatisDao.insert("SYS_USER.insert", userModel);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@JsonResult(info=true,message="删除成功")
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	public Object deleteUser(HttpServletRequest request, Map param) {
		ValidateUtil.notNull(param.get("ids"), "删除的主键不能为空");
		List<Integer> ids = (List<Integer>) param.get("ids");
		Map tem = new HashMap();
		for(Integer id : ids){
			tem.put("id", id);
			tem.put("deleteUID",request.getSession().getAttribute(AresR.USER_ID));
			tem.put("deleteDate",new Date());
			ibatisDao.update("SYS_USER.deleteByID", tem);
		}
		return true;
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
  	@Transactional
  	@JsonResult(info=true,message="获取用户信息列表")
    @ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
	public Object getUserList(HttpServletRequest request, Map param) {
		ValidateUtil.notNull(param.get("pageNumber"), "pageNumber不能为空");
		ValidateUtil.notNull(param.get("pageSize"), "pageSize不能为空");
		param.put("isNotContainAdmin", true);
		return ibatisDao.pageQuery("SYS_USER.getUserList", param, (int)param.get("pageNumber"), (int)param.get("pageSize"));
	}

}
