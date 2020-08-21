package com.culysoft.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;;

//@Component
public class FilterJava implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> headerNames = req.getHeaderNames();
		Map<String, String> mapHeaders = Collections.list(headerNames)
		 	.stream()
		 	.collect(Collectors.toMap(it-> it, req::getHeader));

		if(mapHeaders.get("authentication") != null && mapHeaders.get("authentication").equals("admin")) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendError(403);
		}
	}

}
