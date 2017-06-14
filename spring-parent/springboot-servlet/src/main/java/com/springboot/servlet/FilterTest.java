package com.springboot.servlet;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * 定义过滤器
 * @author maskwang
 *2017年6月12日
 */

@WebFilter(filterName="myFilter",urlPatterns="/*")
public class FilterTest implements Filter {

	@Override
	public void destroy() {
		System.out.println("destory");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤操作");
		String url=req.getRemoteAddr();
		System.out.println(url);
		chain.doFilter(req, res);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");
		
	}

	

}
