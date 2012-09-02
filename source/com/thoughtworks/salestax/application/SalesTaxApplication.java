package com.thoughtworks.salestax.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.salestax.Basket;
import com.thoughtworks.salestax.Inventory;
import com.thoughtworks.salestax.Receipt;
import com.thoughtworks.salestax.exception.SalesTaxApplicationException;

/**
 * SalesTaxApplication
 * 
 * @author codemaniac
 *
 */
public class SalesTaxApplication {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {			
		try {
			// inventory XML file path
			String inventoryXMLFilePath = "/home/codemaniac/Projects/SalesTaxProblem/src/com/thoughtworks/salestax/items.xml";
			// create inventory XML file
			File inventoryXML = new File(inventoryXMLFilePath);
			// create Inventory
			Inventory myInventory = new Inventory(inventoryXML);			
			// input file path
			String basketFilePath = "/home/codemaniac/Projects/SalesTaxProblem/src/com/thoughtworks/salestax/basket.txt";
			// read input file contents
			String text = new Scanner(new File(basketFilePath)).useDelimiter("\\A").next();
			// get all the baskets from input file
			String[] strBaskets = text.split("Input \\d:");
			// for each basket, do
			for (int idx = 1; idx < strBaskets.length; idx++) {
				// create a Basket
				Basket basket = new Basket();
				// for each item in basket, do
				for (String strItem : strBaskets[idx].split("\n")) {
					if (strItem.length() > 0) {
						// parse item to extract quantity, item name and price
						String parts[] = strItem.split(" at ");
						String[] qtyAndName = parts[0].split(" ", 2);						
						// item quantity
						int qty = Integer.parseInt(qtyAndName[0]);
						// item name
						strItem = qtyAndName[1];
						// item price
						Float netAmount = Float.parseFloat(parts[1]);
						// add item to basket						
						basket.addBasketItem(myInventory.getItem(strItem), qty, netAmount);
					}
				}
				// checkout basket and generate receipt
				Receipt myReceipt = basket.checkout();
				// print receipt
				System.out.println(String.format("Output %d:", idx));
				System.out.println(myReceipt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SalesTaxApplicationException e) {
			e.printStackTrace();
		} 

	}

}
