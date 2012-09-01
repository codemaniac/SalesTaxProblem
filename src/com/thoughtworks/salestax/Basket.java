package com.thoughtworks.salestax;

import java.util.ArrayList;
import java.util.List;

public final class Basket {	
	private List<BasketItem> basketItems;
	
	{
		basketItems = new ArrayList<BasketItem>();
	}

	public void addBasketItem(Item item, Integer quantity) {		
		basketItems.add(new BasketItem(item, quantity));
	}
	
	public Receipt checkout() {
		return ReceiptGenerator.generateReceipt(this.basketItems);		
	}
	
}
