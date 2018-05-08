package cn.catering.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.catering.pojo.User;

public class SysInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestURI = request.getRequestURI();
		if (requestURI.indexOf("menuAction") > 0
				|| requestURI.indexOf("navigation") > 0) {
			return true;
		}
		if(requestURI.indexOf("getUser") > 0||requestURI.indexOf("redisLogin")>0){
			return true;
		}
		if(requestURI.indexOf("login") > 0){
			return true;
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if (user == null) {
			response.sendRedirect(request.getContextPath()
					+ "/background/error.jsp");
			return false;
		}
		return true;
	}
}
