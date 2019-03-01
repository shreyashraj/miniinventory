package com.ct.cleartrip.servImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ct.cleartrip.entity.Stock;
import com.ct.cleartrip.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	private static Logger logger = LogManager.getLogger(InventoryServiceImpl.class);
	List<Stock> stockList = new LinkedList<>();
	
	@Override
	public boolean createStock(Stock stock) {
			logger.info("Creating stock");
			if(stockList == null) {
				stockList = new LinkedList<>(); 
			}
			stockList.add(stock);
			if(stockList.isEmpty()) {
				return false;
			}else {
				return true;
			}
	}

	@Override
	public List<Stock> updateItemInStock(Stock stock) {
		logger.info("Updating item in stock");
		int id = stock.getId();
		Iterator<Stock> itrStock = stockList.iterator();
		while(itrStock.hasNext()) {
			if(itrStock.next().id == id) {
				if(itrStock.next().itemQuantity == 0) {
					int newQuanity = (itrStock.next().itemQuantity)+stock.getItemQuantity();
					itrStock.next().itemQuantity = newQuanity;
				}
			}
		}
		return stockList;
	}

	@Override
	public List<Stock> getReport() {
		logger.info("Fetching report for available stock");
		return stockList;
	}

	@Override
	public Stock checkout(Stock stock) {
		logger.info("Checking out item from stock");
		// TODO Auto-generated method stub
		return null;
	}

}
