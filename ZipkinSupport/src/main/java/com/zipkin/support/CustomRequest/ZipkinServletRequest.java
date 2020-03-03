package com.zipkin.support.CustomRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import com.zipkin.support.ZipkinSupportConstants;

public class ZipkinServletRequest extends HttpServletRequestWrapper {

	public ZipkinServletRequest(HttpServletRequest request) {
		super(request);
	}

	public String getHeader(String name) {
		HttpServletRequest request = (HttpServletRequest) getRequest();
		
		String corelationId = request.getHeader(ZipkinSupportConstants.MY_CORELATION_HEADER);
		if (ZipkinSupportConstants.ZIPKIN_HEADERS_L_CASE.contains(name.toLowerCase()) && request.getHeader(name) == null) {
			return corelationId;
		}else if(ZipkinSupportConstants.ZIPKIN_ADDITIONAL_HEADERS.containsKey(name.toLowerCase()) && request.getHeader(name) == null) {
			return ZipkinSupportConstants.ZIPKIN_ADDITIONAL_HEADERS.get(name.toLowerCase());
		}else
			return request.getHeader(name);
		
		/*
		 * if(name.toLowerCase().equals(ZipkinSupportConstants.ZIPKIN_SAMPLLING_HEADER))
		 * return ZipkinSupportConstants.ZIPKIN_ADDITIONAL_HEADERS.get(arg0);
		 */

		
	}

	public Enumeration getHeaderNames() {
		List<String> headerNames = new ArrayList<String>();
		HttpServletRequest request = (HttpServletRequest) getRequest();
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			headerNames.add((String) e.nextElement());
		}
		headerNames.addAll(Arrays.asList(ZipkinSupportConstants.ZIPKIN_HEADERS));
		return Collections.enumeration(headerNames);
	}

}
