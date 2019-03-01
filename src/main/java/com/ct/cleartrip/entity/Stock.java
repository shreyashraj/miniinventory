package com.ct.cleartrip.entity;

public class Stock {
	public int id;
	public String itemName;
	public float itemCost;
	public int itemQuantity;
	

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public float getItemCost() {
		return itemCost;
	}



	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}



	public int getItemQuantity() {
		return itemQuantity;
	}



	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	

	@Override
	public String toString() {
		return "Stock [id=" + id + ", itemName=" + itemName + ", itemCost=" + itemCost + ", itemQuantity="
				+ itemQuantity + "]";
	}



	public Stock(int id, String itemName, float itemCost, int itemQuantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.itemQuantity = itemQuantity;
	}
	
	

}
