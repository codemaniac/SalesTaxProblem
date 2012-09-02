package com.thoughtworks.salestax.unittest;

import static org.junit.Assert.fail;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.salestax.BasketItem;
import com.thoughtworks.salestax.ITaxCalculator;
import com.thoughtworks.salestax.Inventory;
import com.thoughtworks.salestax.Item;
import com.thoughtworks.salestax.SalesAndImportTaxCalculator;
import com.thoughtworks.salestax.exception.SalesTaxApplicationException;

/**
 * SalesAndImportTaxCalculatorTest
 * 
 * Unit test to test the tax computation
 * 
 * @author codemaniac
 *
 */
public class SalesAndImportTaxCalculatorTest {

	@Test
	public void testCalculateTax() {
		// create an instance of SalesAndImportTaxCalculator()
		ITaxCalculator testObject = new SalesAndImportTaxCalculator();
		// test to check existance of instance
		Assert.assertNotNull(testObject);
		try {
			// load inventory XML file
			File inventoryXML = new File("/home/codemaniac/Projects/SalesTaxProblem/src/com/thoughtworks/salestax/items.xml");
			// create inventory
			Inventory inventory = new Inventory(inventoryXML);
			// get an existing item from inventory
			Item item = inventory.getItem("book");
			// create a BasketItem with the above Item and quantity=1
			BasketItem basketItem1 = new BasketItem(item, 1, 12.49f);
			// calculate tax for the above BasketItem 
			Object result = testObject.calculateTax(basketItem1);
			// test if the result is not null
			Assert.assertNotNull(result);	
			// test type of result
			Assert.assertTrue(result instanceof Float);
		} catch (Exception e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}
		
		// test tax calculation for taxable, non-taxable, local and impored items
		try {
			// create non-taxable, local item
			Item lays = new Item("lays", "FOOD", "local");
			// create non-taxable, imported item
			Item pringles = new Item("pringles", "FOOD", "import");
			// create taxable, local item,			
			Item classic = new Item("classic", "OTHER", "local");
			// create taxable, imported item
			Item marlboro = new Item("ferrari", "OTHER", "import");
			
			// calculate tax for non-taxable, local item
			Float result = testObject.calculateTax(new BasketItem(lays, 1, 1f));
			// test tax calculated = 0
			Assert.assertEquals(0.0f, result, 0.0f);
			
			// calculate tax for non-taxable, imported item
			result = testObject.calculateTax(new BasketItem(pringles, 1, 1f));
			// test tax calculated = 5%
			Assert.assertEquals(0.05f, result, 0.0f);
			
			// calculate tax for taxable, local item
			result = testObject.calculateTax(new BasketItem(classic, 1, 1f));
			// test tax calculated = 10%
			Assert.assertEquals(0.1f, result, 0.0f);
			
			// calculate tax for taxable, imported item
			result = testObject.calculateTax(new BasketItem(marlboro, 1, 1f));
			// test tax calculated = 15%
			Assert.assertEquals(0.15f, result, 0.0f);					
		} catch (SalesTaxApplicationException e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}		
	}

}
