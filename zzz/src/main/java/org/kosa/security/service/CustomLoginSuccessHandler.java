package org.kosa.security.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("Login Success");
		System.out.println("====Authentication====");
		System.out.println(authentication);
		
		/* response.sendRedirect("userList"); */
		
		//RequestDispatcher rd=request.getRequestDispatcher("getList");
		//RequestDispatcher rd=request.getRequestDispatcher("mypage");
		//rd.forward(request, response); 
		response.sendRedirect("/mypage");
	}
}
