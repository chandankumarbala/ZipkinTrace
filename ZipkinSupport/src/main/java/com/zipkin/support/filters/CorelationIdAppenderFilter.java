
package com.zipkin.support.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.zipkin.support.CustomRequest.ZipkinServletRequest;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE )
public class CorelationIdAppenderFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (servletRequest instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
			ZipkinServletRequest request = new ZipkinServletRequest(httpServletRequest);
			filterChain.doFilter(request, servletResponse);
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}
}
