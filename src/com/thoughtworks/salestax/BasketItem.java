package com.thoughtworks.salestax;

public class BasketItem {

	private Item item;
	private Integer quantity;
	private Float netAmount;	
	private Float tax;
	private Float grossAmount;

	public BasketItem(Item item, Integer quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
		computeAmountsAndTax();
	}

	private void computeAmountsAndTax() {
		this.netAmount = this.item.getUnitPrice() * this.quantity;
		Boolean isImportedItem = this.item.getIsImported();
		if (isImportedItem) {
			Float tax = 0.05f * this.netAmount;
			this.grossAmount = this.netAmount + tax;
		}		
		Boolean isBasketItemTaxable = this.item.getCatagory().getIsTaxable();
		if (isBasketItemTaxable) {
			Float tax = 0.1f * this.netAmount;
			this.grossAmount = isImportedItem ? this.grossAmount + tax : this.netAmount + tax;
		}
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
}
