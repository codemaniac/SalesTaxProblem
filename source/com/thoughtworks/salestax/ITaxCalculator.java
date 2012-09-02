package com.thoughtworks.salestax;

/**
 * Generic Tax calculator
 * 
 * @author codemaniac
 *
 */
public interface ITaxCalculator {
	
	/**
	 * Calculates tax for a given BasketItem
	 * 
	 * @param item
	 * @return tax calculated
	 */
	public Float calculateTax(BasketItem item);

}
