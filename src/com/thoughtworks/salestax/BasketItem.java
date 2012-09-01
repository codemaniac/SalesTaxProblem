package com.thoughtworks.salestax;

public final class BasketItem {

	private Item item;	
	private Integer quantity;
	private Float netAmount;	
	private Float tax;
	private Float grossAmount;

	public BasketItem(Item item, Integer quantity) {
		super();
		this.item = item;
		this.quantity = quantity;		
		this.netAmount = this.item.getUnitPrice() * this.quantity;
	}
	
	public void setTax(Float tax) {
		this.tax = tax;
		this.grossAmount = this.netAmount + this.tax;
	}	
	
	public Item getItem() {
		return item;
	}		
	
	public String getItemName() {
		return this.item.getName();
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public Float getNetAmount() {
		return netAmount;
	}

	public Float getTax() {
		return tax;
	}
	
	public Float getGrossAmount() {
		return grossAmount;
	}

	@Override
	public String toString() {		
		return String.format("%d %s: %.2f", this.quantity, this.item.getName(), this.grossAmount);
	}	
}
