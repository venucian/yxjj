package cn.com.honzh.modules.yxjj.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.com.honzh.core.base.BaseJsonService;

@Service
@RequestMapping("/upload")
public class UploadPictureService  extends BaseJsonService<MultipartFile>{
	
	    public static String getFileSuffix(String name) {
	        return name.substring(name.lastIndexOf("."), name.length());
	    }

		@Override
		@RequestMapping(value="/picture")
		public Object excute(HttpServletRequest request, MultipartFile imagefile) {
			// 上传图片同时记录值
			String str2 = imagefile.getOriginalFilename();
			// 图片的后缀名；
			int num1 = str2.lastIndexOf("."); // 最后一个.号
			int len1 = str2.length();
			// 只剩下图片的名字没有其他 多余的信息
			String filetype = str2.substring(num1, len1);
			// System.out.println(str3);
			  System.out.println("文件的后缀名" + filetype);
		
			// 项目的路径
//			  String tcatpath = request.getServletContext().getRealPath("/");
			  try {//上传图片,上传到某一个文件夹中
				  imagefile.transferTo(new File("/images/upload/" + imagefile.getOriginalFilename()));
			  System.out.println("图片上传成功");
			  //写入地址,返回地址
			  String newpath="imge\\"
		                + imagefile.getOriginalFilename();
		     return newpath;
	
			} catch (IllegalStateException e) {
			    e.printStackTrace();
			    return false;
			} catch (IOException e) {
			    e.printStackTrace();
			    return false;
			}
	
			  
//			String name = imagefile.getOriginalFilename();
//
//	        //获取当前时间作为最终存储文件的上级目录；
//	        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//	        String today = format.format(new Date());
//
//	        
//	        //保存的文件名：时间戳+六位随机数+文件后缀；
//	        String originalFileName = imagefile.getOriginalFilename();
//	        String newFileName =  today+originalFileName.substring(originalFileName.indexOf("."));
//
////    		String type = imagefile.getOriginalFilename().substring(imagefile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
//    		File targetFile = new File("D:/images/upload/"+newFileName);
//    		if (!targetFile.exists()) {
//    		targetFile.mkdirs();
//    		}
//    		try {
//				imagefile.transferTo(targetFile);
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//    		return  newFileName;
		}
}
