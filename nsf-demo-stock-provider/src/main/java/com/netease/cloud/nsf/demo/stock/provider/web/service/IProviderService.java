package com.netease.cloud.nsf.demo.stock.provider.web.service;

import java.util.List;

import com.netease.cloud.nsf.demo.stock.provider.web.entity.Stock;

public interface IProviderService {

	public List<Stock> getAllStocks();
	
	public Stock getStockById(String stockId);

	public List<Stock> getStocksByIds(String stockIds);
}
