package com.thoughtworks.salestax;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.salestax.exception.SalesTaxApplicationException;

/**
 * Basket
 * 
 * Holds a collection of items purchased
 * 
 * @author codemaniac
 * 
 */
public final class Basket {	
	private List<BasketItem> basketItems;
	
	//initialise
	{		
		basketItems = new ArrayList<BasketItem>();
	}

	/**
	 * Adds an Item to the basket
	 * 
	 * @param item
	 * @param quantity
	 * @throws SalesTaxApplicationException
	 */
	public void addBasketItem(Item item, Integer quantity, Float netAmount) throws SalesTaxApplicationException {		
		if (quantity > 0 )
			basketItems.add(new BasketItem(item, quantity, netAmount));
		else
			throw new SalesTaxApplicationException("Invalid quantity !"); 
	}
	
	/**
	 * Checkout basket to generate Receipt
	 * 
	 * @return Receipt
	 */
	public Receipt checkout() {
		return ReceiptGenerator.generateReceipt(this.basketItems);		
	}
	
}
