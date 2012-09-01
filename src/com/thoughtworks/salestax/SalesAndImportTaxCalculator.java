package com.thoughtworks.salestax;

public final class SalesAndImportTaxCalculator implements ITaxCalculator {
	
	private static final Float IMPORT_TAX_PERCENTAGE = 0.05f; 
	private static final Float SALES_TAX_PERCENTAGE = 0.1f;
	
	@Override
	public Float calculateTax(BasketItem basketItem) {
		Float tax = 0.0f;		
		Boolean isImportedItem = basketItem.getItem().getIsImported();
		if (isImportedItem) {
			tax += IMPORT_TAX_PERCENTAGE * basketItem.getNetAmount();			
		}		
		Boolean isBasketItemTaxable = basketItem.getItem().getCatagory().getIsTaxable();
		if (isBasketItemTaxable) {
			tax += SALES_TAX_PERCENTAGE * basketItem.getNetAmount();			
		}
		return tax;
	}

}
