package com.ct.cleartrip.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ct.cleartrip.entity.Stock;
import com.ct.cleartrip.servImpl.InventoryServiceImpl;
import com.ct.cleartrip.service.InventoryService;
import com.google.gson.Gson;

@RestController
public class InventoryController {

	private static Logger logger = LogManager.getLogger(InventoryController.class);
	
	@Autowired
	InventoryService is = new InventoryServiceImpl();
	
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> welcome() {
		logger.info("Welcome controller called");
		return new ResponseEntity<String>("Welcome to Inventory API", HttpStatus.OK);
	}
	
	@RequestMapping(value="/createStock", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<Map<String,String>> createStock(@RequestBody Stock json){
		logger.info("Create Stock controller called");
		Map<String,String> stockV = new HashMap<>();
		try {
			boolean result =  is.createStock(json);
			if(result) {
				stockV.put("Status","Success");
			}else {
				stockV.put("Error","Failed to create Stock");
			}
		}catch (Exception e) {
			
		}
		return new ResponseEntity<Map<String,String>>(stockV, HttpStatus.OK);

	}
	
	@RequestMapping(value="/getReport", method=RequestMethod.GET, produces="application/json")
	public List<Stock> getReport(){
		logger.info("Report of stock controller called");
		List<Stock> reportItem = is.getReport();
		return reportItem;
	}
	
	@RequestMapping(value="/updateStock", method=RequestMethod.POST, produces="application/json")
	public List<Stock> updateStock(@RequestBody Stock stock){
		logger.info("Controller to update stock called");
		List<Stock> updatedStockItem = is.updateItemInStock(stock);
		return updatedStockItem;
	}
	
	
}
