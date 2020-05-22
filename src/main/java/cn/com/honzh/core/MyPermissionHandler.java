package cn.com.honzh.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import cn.com.honzh.core.base.PermissionHandler;
import cn.com.honzh.core.entity.RequestModel;

@Component
public class MyPermissionHandler implements PermissionHandler {
	
	@Autowired
	Environment env;

	@Override
	public boolean isOnline(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if("dev".equals(env.getProperty("spring.profiles.active"))){
			request.getSession().setAttribute(AresR.USER_ID, 1);
			request.getSession().setAttribute(AresR.LOGIN_NAME, "超级管理员");
			request.getSession().setAttribute(AresR.LOGIN_MARK, true);
			request.getSession().setAttribute(AresR.APP_LOGIN_MARK, true);
			return true;
		}
		return request.getSession().getAttribute(AresR.LOGIN_MARK) != null || request.getSession().getAttribute(AresR.APP_LOGIN_MARK) != null;
	}

	@Override
	public boolean isConflict(HttpServletRequest request) {
		return false;
	}

	@Override
	public boolean isChange(HttpServletRequest request) {
		return false;
	}

	@Override
	public boolean permission(RequestModel model, HttpServletRequest request) {
		return true;
	}

}
