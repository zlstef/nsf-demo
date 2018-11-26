package com.netease.cloud.nsf.demo.stock.viewer.web.interceptor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netease.cloud.nsf.demo.stock.viewer.web.manager.HttpLogManager;

@Component
public class TraceHttpInterceptor implements ClientHttpRequestInterceptor {

	private static Logger log = LoggerFactory.getLogger(TraceHttpInterceptor.class);

	@Autowired
	HttpLogManager logManager;
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		ClientHttpResponse response = execution.execute(request, body);
		
		String path = request.getURI() + "";
		String time = LocalDateTime.now().plusDays(1) + "";
		String respCode = response.getRawStatusCode() + "";
		
		log.debug("invoke " + path);
		log.debug(time + "");
		log.debug("response status : " + respCode);
		
		String[] infos = {time, path, respCode};
		String val = String.join("---->", infos);
		
		String requestId = UUID.randomUUID().toString();
		request.getHeaders().set("requestId", requestId);
		logManager.put(requestId, val);
		
		return response;
	}
	
}