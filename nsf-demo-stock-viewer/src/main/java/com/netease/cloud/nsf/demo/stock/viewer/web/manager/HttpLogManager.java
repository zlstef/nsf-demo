package com.netease.cloud.nsf.demo.stock.viewer.web.manager;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class HttpLogManager {

	private static Map<String, String> HTTP_LOG_MAP = new LinkedHashMap<>();
	
	public void put(String key, String val) {
		
		if(HTTP_LOG_MAP.containsKey(key)) {
			String newVal = HTTP_LOG_MAP.get(key) + val;
			HTTP_LOG_MAP.put(key, newVal);
		} else {
			HTTP_LOG_MAP.put(key, val);
		}
	}
	
	public void clear() {
		HTTP_LOG_MAP.clear();
	}
	
	public String logs() {
		
		StringBuilder builder = new StringBuilder();
		HTTP_LOG_MAP.values().forEach(val -> {
			builder.append(val).append(System.lineSeparator());
		});
		return builder.toString();
	}
}

