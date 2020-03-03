package com.zipkin.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ZipkinSupportConstants {

	public static final String[] ZIPKIN_ID_HEADERS = { "X-B3-TraceId", "X-B3-ParentSpanId", "X-B3-SpanId" };
	public static final String[] ZIPKIN_HEADERS= { "X-B3-TraceId", "X-B3-ParentSpanId", "X-B3-SpanId","X-B3-Sampled","X-B3-Flags" };
	public static final String MY_CORELATION_HEADER="x-corelation-id";
	public static final String ZIPKIN_SAMPLLING_HEADER="X-B3-Sampled";
	public static final String ZIPKIN_FLAGS_HEADER="X-B3-Flags";
	
	
	public static List<String> ZIPKIN_HEADERS_L_CASE=new ArrayList<>();
	public static Map<String,String> ZIPKIN_ADDITIONAL_HEADERS=new HashMap<>();
	static {
		ZIPKIN_HEADERS_L_CASE=Arrays.asList(ZIPKIN_ID_HEADERS).stream().map(String::toLowerCase).collect(Collectors.toList());
		ZIPKIN_ADDITIONAL_HEADERS.put(ZIPKIN_SAMPLLING_HEADER.toLowerCase(), "0");
	}
}
