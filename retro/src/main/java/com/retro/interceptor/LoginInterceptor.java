package com.retro.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter{

	// 메인액션 실행되기전! preHandle은  boolean 자료형이니 true와 false만 들어올수있음.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// session체크, 값이 있으면 통과,
		// 없으면 돌려보냄(원래페이지로 가서 모달창 키고 에러메시지 출력!)
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userid") == null) {
			log.info("로그인 해주세요");
			
			String referer = request.getHeader("referer");  // AJAX 기능을 이용하면 자동적으로 원래페이지로 이동하나
			response.sendRedirect(referer + "?message=nologin");  // 인터셉터는 해당작업을 진행하지 않으니 referer 작성
			
			return false;
		} else {
			log.info(">>>>우와 통과해주세요.");
			return true;
		}
		
		
		
		//return false; => 못들어감 돌아가게만듬.
		//return true; => 통과! 메인액션 실행.		
	}
	
	// 메인액션 실행된후.	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
