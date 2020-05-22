//package cn.com.honzh.modules.yxjj.app;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.CacheManager;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSONObject;
//
//import cn.com.honzh.core.annotation.JsonResult;
//import cn.com.honzh.core.annotation.UserPermission;
//import io.swagger.annotations.Api;
//
//@SuppressWarnings("rawtypes")
//@RestController
//@RequestMapping(value = "/app")
//@Api(tags = "登录服务")
//public class LoginTestService{
//	
//	@Autowired
//	CacheManager cache;
//	
//	 private static final long serialVersionUID = 1L;
//		
//	 private static final String APPID = "wxea4aa9aecc3fbf76";  
//	 //TODO SECRET
//	 private static final String SECRET = "9a365256fbe6a2385353a92203935132";  
//	 private static final String grant_type = "authorization_code";
//	 private static final String URL = "https://api.weixin.qq.com/sns/jscode2session?";
//
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@UserPermission(open = true)
//	@JsonResult(info=true,message="登陆成功")
//	@RequestMapping(value = "/login")
//	public Object excute(HttpServletRequest request, Map reqMap){
//		String appid = request.getParameter("appId").toString();
//		String js_code = request.getParameter("js_code").toString();
//		String secret = request.getParameter("appSecret").toString();		
//		String params ="appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";
//		System.out.println(params);	
////此处为拷贝res.code过来执行测试是否可行，一开始因为拼凑的等号前面多了一个控制
////导致的错误，才这样测试
////		String params2 ="appid=wxae6ffe97d0fee46f&secret=925e344466e932fb7577e154077b1781
////&js_code=071wRPwb0upIEx1Yp9yb0bsSwb0wRPwA&grant_type=authorization_code";
// 
//////	String sr =us.getopenid("http://localhost:8080/WebTest2/returnInfoServlet?",params2);		
//
//		String sr =getOpenid("https://api.weixin.qq.com/sns/jscode2session?",params);
//		JSONObject job = JSONObject.fromObject(sr);
//		PrintWriter pw2 = response.getWriter();
//		pw2.write(job.toString());
//		System.out.println(job.toString()+"  sessionKey:"+job.get("session_key"));
//	  }
//
//	}
//
//
//public String getOpenid(String urlParam, String param) {  
//    BufferedReader in = null;  
//    //appid和secret是开发者分别是小程序ID和小程序密钥，开发者通过微信公众平台-》设置-》开发设置就可以直接获取，
//    String url=urlParam+param;
//    try {  
//	URL Url = new URL(url); 
//        // 打开和URL之间的连接  
//        URLConnection connection = Url.openConnection();  
//        // 设置通用的请求属性  
//        connection.setConnectTimeout(5000);  
//        connection.setReadTimeout(5000);  
//        // 建立实际的连接  
//        connection.connect();  
//        // 定义 BufferedReader输入流来读取URL的响应  
//        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
//        StringBuffer sb = new StringBuffer();  
//        String line;  
//        while ((line = in.readLine()) != null) {  
//            sb.append(line);  
//        }  
//        return sb.toString();  
//    } catch (Exception e1) {  
//    	throw new RuntimeException(e1);
//    }  
//    // 使用finally块来关闭输入流  
//    finally {  
//        try {  
//            if (in != null) {  
//                in.close();  
//            }  
//        } catch (Exception e2) {  
//            e2.printStackTrace();  
//        }  
//    }  
//}  
//
//
//}
