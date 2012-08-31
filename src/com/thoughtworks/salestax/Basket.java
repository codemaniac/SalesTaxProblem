package com.thoughtworks.salestax;

import java.util.ArrayList;
import java.util.List;

public class Basket {	
	private List<BasketItem> basketItems;
	
	{
		basketItems = new ArrayList<BasketItem>();
	}

	public void addBasketItem(BasketItem item) {
		basketItems.add(item);
	}
	
	public List<BasketItem> getBasketItems() {
		return basketItems;
	}
}
