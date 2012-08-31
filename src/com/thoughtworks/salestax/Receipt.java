package com.thoughtworks.salestax;

import java.util.List;

public class Receipt {
	private Basket basket;
	private Float netTotal;
	private Float totalTax;
	private Float grossTotal;
	
	public Receipt(Basket basket) {
		super();
		this.basket = basket;
		computeTotals();		
	}
	
	private void computeTotals() {
		List<BasketItem> items = basket.getBasketItems();
		for (BasketItem item : items) {
			this.netTotal += item.getNetAmount();
			this.totalTax += item.getTax();
		}
		this.grossTotal = this.netTotal + this.totalTax;
	}

	@Override
	public String toString() {
		StringBuilder receiptStr = new StringBuilder();
		List<BasketItem> items = basket.getBasketItems();
		for (BasketItem item : items) {
			Integer qty = item.getQuantity();
			String itemName = item.getItemName();
			Float grossAmount = item.getGrossAmount();
			String receiptItemLine = String.format("%d %s: %.2f\n", qty, itemName, grossAmount);
			receiptStr.append(receiptItemLine);
		}
		String receiptSalesTaxLine = String.format("Sales Taxes: %.2f\n", this.totalTax);
		String receiptTotalLine = String.format("Total: %.2f\n", this.grossTotal);
		receiptStr.append(receiptSalesTaxLine);
		receiptStr.append(receiptTotalLine);
		return receiptStr.toString();
	}
		
}
