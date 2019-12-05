package com.geminno.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EcodeFilter implements Filter{
	private String encode = "utf-8";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		((HttpServletRequest)request).setCharacterEncoding(encode);
		((HttpServletResponse)response).setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		String enco=arg0.getInitParameter("encode");
		if(enco!=null){
			encode=enco;
		}
	}
	
}
