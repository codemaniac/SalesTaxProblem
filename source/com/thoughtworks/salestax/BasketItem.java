package com.thoughtworks.salestax;

/**
 * BasketItem
 * 
 * Each item that is placed in the Basket
 * 
 * @author codemaniac
 */
public final class BasketItem {

	private Item item;	
	private Integer quantity;
	private Float netAmount;	
	private Float tax;
	private Float grossAmount;

	/**
	 * Create a BasketItem
	 * 
	 * @param item
	 * @param quantity
	 */
	public BasketItem(Item item, Integer quantity, Float netAmount) {
		super();
		this.item = item;
		this.quantity = quantity;		
		this.netAmount = netAmount;
	}
	
	/**
	 * Sets the calculated tax amount for the BasketItem 
	 * 
	 * @param tax
	 */
	public void setTax(Float tax) {
		this.tax = tax;
		this.grossAmount = this.netAmount + this.tax;
	}	
	
	/**
	 * @return Item 
	 */
	public Item getItem() {
		return item;
	}	
	
	/**
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	
	/**
	 * @return net amount
	 */
	public Float getNetAmount() {
		return netAmount;
	}

	/**
	 * @return total tax computed
	 */
	public Float getTax() {
		return tax;
	}
	
	/**
	 * @return gross amount = net amount + tax
	 */
	public Float getGrossAmount() {
		return grossAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return String.format("%d %s: %.2f", this.quantity, this.item.getName(), this.grossAmount);
	}	
}
