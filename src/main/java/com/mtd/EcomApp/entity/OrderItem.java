package com.mtd.EcomApp.entity;

public class OrderItem {
	private String item_id;
	private String qty;
	private String price;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public OrderItem() {
		super();
	}
	public OrderItem(String item_id, String qty, String price) {
		super();
		this.item_id = item_id;
		this.qty = qty;
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [item_id=" + item_id + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
	

}
