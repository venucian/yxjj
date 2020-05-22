package cn.com.honzh.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import cn.com.honzh.core.dao.IbatisDao;

/**
 * 数据操作日志 
 * @author peng.li
 * @company 洛阳鸿卓电子信息技术有限公司
 * @create 2019年1月9日
 */
@Service
@SuppressWarnings({"unchecked","rawtypes"})
public class DataRecordLogService {
	
	@Autowired
	IbatisDao ibatisDao;
	
	public void addDataLog(@NonNull Object tableID,Object pkID,Object createUID,Object inParam, Object operationApi, Object channel){
		
		Map log = new HashMap();
		log.put("tableID", tableID);
		log.put("pkID", pkID);
		log.put("operationApi", operationApi);
		log.put("inParam", inParam);
		log.put("channel", channel);
		log.put("createUID", createUID);
		log.put("createDate", new Date());
		ibatisDao.insert("SYS_DATA_LOG.insert", log);
		
	}
}
