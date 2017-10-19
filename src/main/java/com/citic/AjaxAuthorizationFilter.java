package com.citic;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * 1.自定义角色鉴权过滤器(满足其中一个角色则认证通过) 2.扩展异步请求认证提示功能;
 * 
 * @author shadow
 * 
 */
public class AjaxAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		// super.onAccessDenied(request, response);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// HttpServletResponse httpResponse = (HttpServletResponse) response;

		Subject subject = getSubject(request, response);
		// If the subject isn't identified, redirect to login URL
		if (subject.getPrincipal() == null) {
			if (isAjaxRequest(httpRequest)) {
//				Result<String> result = new Result<String>();
//				result.failed("您尚未登录或登录时间过长,请重新登录!");
				response.setContentType("text/html; charset=utf-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				// 将数据拼接成JSON格式
//				out.print(JSON.toJSONString(result));
				out.print(response);
				out.flush();
				out.close();
			} else {
				saveRequestAndRedirectToLogin(request, response);
			}
		} else {
			return true;
		}

		return false;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false;
	}

	/**
	 * 判断是否为Ajax请求
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 是true, 否false
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		} else {
			return false;
		}
	}

}