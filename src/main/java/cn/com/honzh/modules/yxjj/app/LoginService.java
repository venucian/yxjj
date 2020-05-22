package cn.com.honzh.modules.yxjj.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.com.honzh.common.AesCbcUtil;
import cn.com.honzh.common.HttpRequest;
import cn.com.honzh.modules.yxjj.entry.ResultUtil;
import cn.com.honzh.modules.yxjj.entry.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping(value = "/app")
@Api(tags = "解密用户信息")
public class LoginService{
	
	@Autowired
	CacheManager cache;
	
	 private static final long serialVersionUID = 1L;
		
	 private static final String APPID = "wxea4aa9aecc3fbf76";  
	 private static final String SECRET = "9a365256fbe6a2385353a92203935132";  
	 private static final String GRANT_TYPE = "authorization_code";
	 private static final String URL = "https://api.weixin.qq.com/sns/jscode2session";
	 /**
      * @Title: decodeUserInfo
      * @author：lipeng
      * @Description: 解密用户敏感数据
      * @param encryptedData 明文,加密数据
      * @param iv   加密算法的初始向量
      * @param code  用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
      * @return
 	  */
	 	   @SuppressWarnings("unchecked")
	 	   @RequestMapping(value = "/decodeUserInfo.do", method = RequestMethod.POST)
	 	   @ResponseBody
	 	  public ResultUtil decodeUserInfo(@ApiParam(name="encryptedData",value="明文,加密数据",required=true) @RequestParam("encryptedData") String encryptedData, 
	 			 @ApiParam(name="iv",value="加密算法的初始向量",required=true)@RequestParam("iv") String iv, 
	 			 @ApiParam(name="code",value="code",required=true) @RequestParam("code") String code){
	 		  ResultUtil resultUtil = new ResultUtil();
	 		   Map map = new HashMap();
		 		// 登录凭证不能为空
		 		if (code == null || code.length() == 0) {
		 			resultUtil.setMsg("code 不能为空");
		 			resultUtil.setStatus(2001);
		 			return resultUtil;
		 		}
		  
		 		//////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
		 		//////////////// ////////////////
		 		// 请求参数
		 		String params = "appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type="
		 				+ GRANT_TYPE;
		 		// 发送请求
		 		String sr = HttpRequest.sendGet(URL, params);
		 		// 解析相应内容（转换成json对象）
		 		JSONObject json = JSONObject.parseObject(sr);
		 		// 获取会话密钥（session_key）
		 		String session_key = json.get("session_key").toString();
		 		// 用户的唯一标识（openid）
//		 		String openid = (String) json.get("openid");
		  
		 		//////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
		 		try {
		 			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
		 			if (null != result && result.length() > 0) {
		 				resultUtil.setMsg("解密成功");
			 			resultUtil.setStatus(2000);
			 			
	
		  
		 				JSONObject userInfoJSON = JSONObject.parseObject(result);
		 				UserModel userModel = new UserModel();
		 				userModel.setOpenID(userInfoJSON.get("openId") != null ? userInfoJSON.get("openId").toString() : null);
//		 				userInfo.put("openId", userInfoJSON.get("openId"));
		 				userModel.setNickName(userInfoJSON.get("nickName") != null ? userInfoJSON.get("nickName").toString() : null);

//		 				userInfo.put("nickName", userInfoJSON.get("nickName"));
		 				userModel.setWxPhotoUrl(userInfoJSON.get("avatarUrl") != null ? userInfoJSON.get("avatarUrl").toString() : null);
		 				userModel.setCity(userInfoJSON.get("city") != null ? userInfoJSON.get("city").toString() : null);
		 				userModel.setUnionId(userInfoJSON.get("province") != null ? userInfoJSON.get("province").toString() : null);
		 				userModel.setUnionId(userInfoJSON.get("country") != null ? userInfoJSON.get("country").toString() : null);
		 				userModel.setUnionId(userInfoJSON.get("unionId") != null ? userInfoJSON.get("unionId").toString() : null);
		 				userModel.setUnionId(userInfoJSON.get("gender") != null ? userInfoJSON.get("gender").toString() : null);
		 				resultUtil.setData(userModel);
//		 				userInfo.put("gender", userInfoJSON.get("gender"));
//		 				userInfo.put("city", userInfoJSON.get("city"));
//		 				userInfo.put("province", userInfoJSON.get("province"));
//		 				userInfo.put("country", userInfoJSON.get("country"));
//		 				userInfo.put("wxPhotoUrl", userInfoJSON.get("avatarUrl"));
//		 				userInfo.put("unionId", userInfoJSON.get("unionId"));
//		 				map.put("userInfo", userInfo);
		 			} else {
		 				resultUtil.setMsg("解密失败");
			 			resultUtil.setStatus(2001);
			 			return resultUtil;
		 			}
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 		}
		 		return resultUtil;
	 	   }
//	 	   public Map decodeUserInfo(String encryptedData, String iv, String code){
//	  
//		 		Map map = new HashMap();
//		  
//		 		// 登录凭证不能为空
//		 		if (code == null || code.length() == 0) {
//		 			map.put("status", 0);
//		 			map.put("msg", "code 不能为空");
//		 			return map;
//		 		}
//		  
//		 		//////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
//		 		//////////////// ////////////////
//		 		// 请求参数
//		 		String params = "appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type="
//		 				+ GRANT_TYPE;
//		 		// 发送请求
//		 		String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
//		 		// 解析相应内容（转换成json对象）
//		 		JSONObject json = JSONObject.parseObject(sr);
//		 		// 获取会话密钥（session_key）
//		 		String session_key = json.get("session_key").toString();
//		 		// 用户的唯一标识（openid）
//		 		String openid = (String) json.get("openid");
//		  
//		 		//////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
//		 		try {
//		 			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
//		 			if (null != result && result.length() > 0) {
//		 				map.put("status", 1);
//		 				map.put("msg", "解密成功");
//		  
//		 				JSONObject userInfoJSON = JSONObject.parseObject(result);
//		 				Map userInfo = new HashMap();
//		 				userInfo.put("openId", userInfoJSON.get("openId"));
//		 				userInfo.put("nickName", userInfoJSON.get("nickName"));
//		 				userInfo.put("gender", userInfoJSON.get("gender"));
//		 				userInfo.put("city", userInfoJSON.get("city"));
//		 				userInfo.put("province", userInfoJSON.get("province"));
//		 				userInfo.put("country", userInfoJSON.get("country"));
//		 				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
//		 				// 解密unionId & openId;
//		  
//		 				userInfo.put("unionId", userInfoJSON.get("unionId"));
//		 				map.put("userInfo", userInfo);
//		 			} else {
//		 				map.put("status", 0);
//		 				map.put("msg", "解密失败");
//		 			}
//		 		} catch (Exception e) {
//		 			e.printStackTrace();
//		 		}
//		 		return map;
//		 	}    


}
