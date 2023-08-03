package com.kosa.controller;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("���� �ʱ�ȭ");
    }

    @Override
    public void destroy() {
        System.out.println("���� �Ҹ�");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse); //���� ������ �̻��϶� ����
    }
}

/*
destory() - ���Ͱ� �� �����̳ʿ��� ������ �� ȣ��˴ϴ�.
doFilter(ServletRequest request, ServletResponse response, FilterChain chain) - �� �޼��带 ���ؼ� ��û(Request)�� ����(Response)
���� ü���� ����� ������ �����̳ʿ��� ȣ��˴ϴ�. ü���� ���� ��� ������ �����ϴ� ���ͷ� �̵��ϴ� �� �Դϴ�.
init() - ���͸� �� �����̳� ���� ������ �� �ʱ�ȭ�Ҷ� ȣ��˴ϴ�.
*/