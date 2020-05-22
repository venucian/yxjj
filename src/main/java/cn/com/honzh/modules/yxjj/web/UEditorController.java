package cn.com.honzh.modules.yxjj.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.swagger.annotations.Api;

@Controller
@Api(value = "富文本文件上传",tags = "富文本")
@RequestMapping("/ueditor")
public class UEditorController {
	
	@Value("${HONZH_NATIVE_FILEPATH}")
	String localPath;
	
	@RequestMapping(method = RequestMethod.GET,value="/upload")
	public String getConfig(HttpServletRequest request){
		return "/ueditor/config.json";
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value="/upload")
	public Map upload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map map = new HashMap();
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest mq = (MultipartHttpServletRequest) request;
			
			MultipartFile file = mq.getFile("upfile");
			

			String originalFilename = file.getOriginalFilename();
			// 新文件名称
			
//			String fileName = StringUtil.UUIDGenerator() + originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
//			String path = "/down/ueditor" + "/" + DateUtil.formatDateToStr(new Date(), "yyyyMMdd");
//			
//			File dir = new File(localPath + path);
//			
//			if(!dir.exists()){
//				dir.mkdirs();
//			}
//			
//			File local = new File(dir,fileName);
//			
//			file.transferTo(local);
//			
//			String url = path + "/" + fileName;
//			
//			if(fileName.endsWith("jpg")||fileName.endsWith("png")||fileName.endsWith("jpeg")||fileName.endsWith("gif")){
//				
//				url += "?width=600";
//				
//				BufferedImage bufferedImg = ImageIO.read(new FileInputStream(local));
//				int imgWidth = bufferedImg.getWidth();
//				int imgHeight = bufferedImg.getHeight();
//				
//				if(imgHeight != 0){
//					url += ("&rate=" + new BigDecimal(imgWidth).divide(new BigDecimal(imgHeight),2, RoundingMode.HALF_UP).toString());
//				}
//			}
//			
//			ftp.upload(local, path, fileName);
//			
//			map.put("url", url); 
//			map.put("state", "SUCCESS");
//			
//			local.delete();
		}
		return map;
	}
}
