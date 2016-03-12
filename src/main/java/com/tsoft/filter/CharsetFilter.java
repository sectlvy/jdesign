package com.tsoft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class CharsetFilter implements Filter {
	private FilterConfig filterConfig;
	private Logger logger = Logger.getLogger(CharsetFilter.class);
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String currentEncodingStyle = this.filterConfig.getInitParameter("codeEncoding");
		response.getCharacterEncoding();
		request.getCharacterEncoding();
		if(currentEncodingStyle!=null && !response.getCharacterEncoding().equals(currentEncodingStyle)){
			response.setCharacterEncoding(currentEncodingStyle);
		}
		logger.info("CharsetFilter 设置 系统业务请求响应 response 编码为："+response.getCharacterEncoding());
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
