package com.netease.cloud.nsf.demo.stock.viewer.web.configuration;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.netease.cloud.nsf.demo.stock.viewer.web.interceptor.TraceHttpInterceptor;

/**
 * @author chenjiahan
 */
@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	TraceHttpInterceptor traceHttpInterceptor;

	@Autowired
	RestTemplate restTemplate;

	@PostConstruct
	public void restTemplateInterceptors() {
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if(!interceptors.contains(traceHttpInterceptor)) {
			interceptors.add(traceHttpInterceptor);
			restTemplate.setInterceptors(interceptors);
		}
	}
}
