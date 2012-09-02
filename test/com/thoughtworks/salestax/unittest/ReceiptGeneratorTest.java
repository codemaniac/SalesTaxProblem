package com.thoughtworks.salestax.unittest;

import static org.junit.Assert.fail;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.salestax.Basket;
import com.thoughtworks.salestax.Inventory;
import com.thoughtworks.salestax.Receipt;

/**
 * ReceiptGeneratorTest
 * 
 * Unit test to check generation of receipt for a basket
 * 
 * @author codemaniac
 *
 */
public class ReceiptGeneratorTest {

	/**
	 * Unit test for generateReceipt method
	 */
	@Test
	public void testGenerateReceipt() {		
		try {
			// load inventory XML file
			File inventoryXML = new File("/home/codemaniac/Projects/SalesTaxProblem/src/com/thoughtworks/salestax/items.xml");
			// create inventory
			Inventory inventory = new Inventory(inventoryXML);
			// create basket
			Basket basket = new Basket();
			// add some items to the basket
			basket.addBasketItem(inventory.getItem("book"), 1, 12.49f);
			basket.addBasketItem(inventory.getItem("music CD"), 1, 14.99f);
			// perform basket checkout
			Object testObject = basket.checkout();
			// test if the checkout process has yielded a result
			Assert.assertNotNull(testObject);
			// test type of result
			Assert.assertTrue(testObject instanceof Receipt);
		} catch (Exception e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}
		
		try {
			// load inventory XML file
			File inventoryXML = new File("/home/codemaniac/Projects/SalesTaxProblem/src/com/thoughtworks/salestax/items.xml");
			// create inventory
			Inventory inventory = new Inventory(inventoryXML);
			// create an empty basket
			Basket basket = new Basket();
			// perform a checkout on an empty basket
			Object testObject = basket.checkout();
			// test to see if no receipt is generated
			Assert.assertNull(testObject);
		} catch (Exception e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}
	}

}
