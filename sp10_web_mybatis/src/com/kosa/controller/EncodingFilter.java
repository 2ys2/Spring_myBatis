package com.kosa.controller;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("필터 초기화");
    }

    @Override
    public void destroy() {
        System.out.println("필터 소멸");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse); //필터 여러개 이상일때 순서
    }
}

/*
destory() - 필터가 웹 컨테이너에서 삭제될 때 호출됩니다.
doFilter(ServletRequest request, ServletResponse response, FilterChain chain) - 이 메서드를 통해서 요청(Request)와 응답(Response)
쌍이 체인을 통과할 때마다 컨테이너에서 호출됩니다. 체인을 따라서 계속 다음에 존재하는 필터로 이동하는 것 입니다.
init() - 필터를 웹 컨테이너 내에 생성한 후 초기화할때 호출됩니다.
*/