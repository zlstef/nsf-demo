package com.netease.cloud.nsf.demo.stock.provider.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netease.cloud.nsf.demo.stock.provider.web.client.MockClient;
import com.netease.cloud.nsf.demo.stock.provider.web.client.NeteaseStockClient;
import com.netease.cloud.nsf.demo.stock.provider.web.client.StockClient;

@Configuration
public class ProviderConfig {

	@Bean(name="remoteRestTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	@ConditionalOnProperty(name="offline", havingValue="true")
	public StockClient mockStockClient() {
		return new MockClient();
	}
	
	@Bean
	@ConditionalOnMissingBean
	public StockClient neteaseStockClient() {
		return new NeteaseStockClient();
	}
}
