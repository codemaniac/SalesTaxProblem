package com.thoughtworks.salestax;

import java.util.List;

public final class Receipt {	
	private List<BasketItem> items;
	private Float netTotal;
	private Float totalTax;
	private Float grossTotal;
	
	public Receipt(List<BasketItem> items, Float netTotal, Float totalTax,
			Float grossTotal) {
		super();
		this.items = items;
		this.netTotal = netTotal;
		this.totalTax = totalTax;
		this.grossTotal = grossTotal;
	}

	@Override
	public String toString() {
		StringBuilder receiptStr = new StringBuilder();
		for (BasketItem item : this.items) {			
			receiptStr.append(item.toString());
			receiptStr.append("\n");
		}
		String receiptSalesTaxLine = String.format("Sales Taxes: %.2f\n", this.totalTax);
		String receiptTotalLine = String.format("Total: %.2f\n", this.grossTotal);
		receiptStr.append(receiptSalesTaxLine);
		receiptStr.append(receiptTotalLine);
		return receiptStr.toString();
	}
		
}
