package com.thoughtworks.salestax;

public class Main {
	
	public static void main(String[] args) {		
		Item item1 = new Item("book", "BOOK", 12.49f, "local");
		Item item2 = new Item("music CD", "OTHER", 14.99f, "local");
		Item item3 = new Item("chocolate bar", "FOOD", 0.85f, "local");
						
		Basket myBasket = new Basket();
		
		myBasket.addBasketItem(item1, 1);
		myBasket.addBasketItem(item2, 1);
		myBasket.addBasketItem(item3, 1);		
				
		Receipt myReceipt = myBasket.checkout();
		
		System.out.println(myReceipt);			
		
	}

}
