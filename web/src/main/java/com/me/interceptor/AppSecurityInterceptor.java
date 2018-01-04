package com.me.interceptor;

import com.me.common.exception.BusinessException;
import com.me.common.exception.ErrorCode;
import com.me.utils.ConstantsUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jack rose on 2018/1/4.
 */
public class AppSecurityInterceptor extends HandlerInterceptorAdapter {



	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

		String requestUri = request.getRequestURI();

		String authToken = request.getHeader(ConstantsUtils.AUTH_TOKEN_HEADER_NAME);
		if(null == authToken || authToken.equals("")){
			throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}
}
