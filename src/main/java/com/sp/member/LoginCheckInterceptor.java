package com.sp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result=true;
		
		try {
			HttpSession session=request.getSession();
			SessionInfo info = (SessionInfo)session.getAttribute("member");
			String cp=request.getContextPath();
			String uri=request.getRequestURI();
			String queryString = request.getQueryString(); // GET 방식 쿼리 스트링
			
			if(info!=null)
				return result;
			
			result = false;
			if(isAjaxRequest(request)) {
				response.sendError(403);
			} else {
				if(uri.indexOf(cp)==0) {
					uri=uri.substring(cp.length());
				}
				if(queryString!=null) {
					uri+="?"+queryString;
				}
				session.setAttribute("preLoginURI", uri);
				response.sendRedirect(cp+"/member/login");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	/*
	   컨트롤러가 요청을 처리 한 후에 호출. 컨트롤러 실행 중 예외가 발생하면 실행 하지 않음  
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	/*
	  클라이언트 요청을 처리한 뒤, 즉 뷰를 통해 클라이언트에 응답을 전송한 뒤에 실행
	  컨트롤러 처리 중 또는 뷰를 생성하는 과정에 예외가 발생해도 실행  
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	// AJAX 요청인지를 확인하기 위한 메소드
	// AJAX로 요청할 때 header에 AJAX:true를 추가해서 요청 
	private boolean isAjaxRequest(HttpServletRequest req) {
		String h = req.getHeader("AJAX");
		return h!=null && h.equals("true");
	}

}
