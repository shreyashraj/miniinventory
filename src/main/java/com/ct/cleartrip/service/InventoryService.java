package com.ct.cleartrip.service;

import java.util.List;

import com.ct.cleartrip.entity.Stock;

public interface InventoryService {
	
	public boolean createStock(Stock stock);
	public List<Stock> updateItemInStock(Stock stock);
	public List<Stock> getReport();
	public Stock checkout(Stock stock);
	
}
