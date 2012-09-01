package com.thoughtworks.salestax;

import java.util.List;

public final class ReceiptGenerator {

	private static ITaxCalculator taxCalculator;
	
	static {
		taxCalculator = new SalesAndImportTaxCalculator();
	}
	
	public static synchronized Receipt generateReceipt(List<BasketItem> basketItems) {		
		Float netTotal = 0.0f;
		Float totalTax = 0.0f;
		Float grossTotal = 0.0f;
		for (BasketItem item : basketItems) {
			Float itemTax = taxCalculator.calculateTax(item);
			item.setTax(itemTax);
			netTotal += item.getNetAmount();
			totalTax += item.getTax();
		}
		grossTotal = netTotal + totalTax;		
		return new Receipt(basketItems, netTotal, totalTax, grossTotal);
	}
	
}
