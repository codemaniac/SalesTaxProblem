package com.thoughtworks.salestax;

import java.util.List;

/**
 * ReceiptGenerator
 * 
 * Generates the receipt for a Basket
 * 
 * @author codemaniac
 *
 */
public final class ReceiptGenerator {

	/**
	 * Tax calculator 
	 */
	private static ITaxCalculator taxCalculator;
	
	// initialise
	static {
		taxCalculator = new SalesAndImportTaxCalculator();
	}
	
	/**
	 * Generates a Receipt for a list of BasketItems.
	 * 
	 * @param basketItems
	 * @return Receipt
	 */
	public static synchronized Receipt generateReceipt(List<BasketItem> basketItems) {	
		if (basketItems.size() == 0)
			return null;
		Float netTotal = 0.0f;
		Float totalTax = 0.0f;
		Float grossTotal = 0.0f;
		for (BasketItem item : basketItems) {
			Float itemTax = taxCalculator.calculateTax(item);
			// sets back the computed tax to the Item
			// and hence, a synchronized method
			item.setTax(itemTax);
			netTotal += item.getNetAmount();
			totalTax += item.getTax();
		}
		grossTotal = netTotal + totalTax;		
		return new Receipt(basketItems, netTotal, totalTax, grossTotal);
	}
	
}
