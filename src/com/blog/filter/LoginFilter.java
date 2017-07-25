package com.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("登陆拦截");

		HttpServletRequest hreq = (HttpServletRequest) req;

		if (null == hreq.getSession().getAttribute("user")) {
			//((HttpServletResponse) resp).setHeader("refresh","0;URL=/Blog/static_resource/login/login.html");
			System.out.println("卧槽");
			((HttpServletResponse)resp).sendRedirect("/Blog/static_resource/login/login.html");
		}
		chain.doFilter(req, resp);

		System.out.println("登陆拦截结束");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
