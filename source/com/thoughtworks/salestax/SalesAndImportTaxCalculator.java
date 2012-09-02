package com.thoughtworks.salestax;

import java.text.DecimalFormat;

/**
 * SalesAndImportTaxCalculator
 * 
 * Implementation of ITaxCalculator that compuutes Sales tax and Import Tax 
 * 
 * @author codemaniac
 *
 */
public final class SalesAndImportTaxCalculator implements ITaxCalculator {
	
	/**
	 * Tax percentage amount for Imported items
	 */
	private static final Float IMPORT_TAX_PERCENTAGE = 0.05f;
	
	/**
	 * Tax percentage amount for taxable items
	 */
	private static final Float SALES_TAX_PERCENTAGE = 0.1f;
	
	/**
	 * Float precision formatter 
	 */
	DecimalFormat decimalFormat = new DecimalFormat("###.###");
	
	/* (non-Javadoc)
	 * @see com.thoughtworks.salestax.ITaxCalculator#calculateTax(com.thoughtworks.salestax.BasketItem)
	 */
	@Override
	public Float calculateTax(BasketItem basketItem) {
		Float tax = 0.0f;		
		Boolean isImportedItem = basketItem.getItem().getIsImported();
		if (isImportedItem) {
			tax += roundOffFloat(IMPORT_TAX_PERCENTAGE * basketItem.getNetAmount());			
		}		
		Boolean isBasketItemTaxable = basketItem.getItem().getCatagory().getIsTaxable();
		if (isBasketItemTaxable) {
			tax += roundOffFloat(SALES_TAX_PERCENTAGE * basketItem.getNetAmount());			
		}
		return tax;
	}
	
	/**
	 * rounds off float to 2 places after decimal point
	 * 
	 * @param val
	 * @return rounded of value
	 */
	private Float roundOffFloat(Float val) {
		return Float.parseFloat(decimalFormat.format(val));
	}

}
