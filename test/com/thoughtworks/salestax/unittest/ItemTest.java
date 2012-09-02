package com.thoughtworks.salestax.unittest;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.salestax.Item;
import com.thoughtworks.salestax.exception.SalesTaxApplicationException;

/**
 * ItemTest
 * 
 * Unit tests for com.thoughtworks.salestax.Item
 * 
 * @author codemaniac
 *
 */
public class ItemTest {

	/**
	 * Unit test for constructor
	 */
	@Test
	public void testItem() {
		try {			
			// create an Item and test for not null
			Assert.assertNotNull(new Item("Nails", "OTHER", "local"));
		} catch (Exception e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}
		
		try {
			// create an item with a non-existant item catagory "FANCY"
			Item testObj = new Item("Nails", "FANCY", "local");
			// if no exception is thrown at this point, fail the test
			fail("Something went wrong! Expected NoSuchCatagoryException but gone none !");
		} catch (Exception e) {
			// test if an exception is caught
			Assert.assertNotNull(e);
			// test type of exception caught
			Assert.assertTrue(e instanceof SalesTaxApplicationException);
		}
		
		try {			
			// create imported item and test it's taxable
			// Only type="import" is liable to be taxed
			Item testObj1 = new Item("Nails", "OTHER", "import");
			Assert.assertTrue(testObj1.getIsImported());
			// create non-imported item and test it's taxable
			Item testObj2 = new Item("Nails", "OTHER", "local");			
			Assert.assertFalse(testObj2.getIsImported());
			// create non-imported item and test it's taxable
			Item testObj3 = new Item("Nails", "OTHER", "chineese");
			Assert.assertFalse(testObj3.getIsImported());
		} catch (Exception e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}
		
		try {
			// create an item with no name
			Item testObj1 = new Item("", "OTHER", "local");
			// if no exception is thrown at this point, fail the test
			fail("Something went wrong! Expected NoItemNameException but got none !");			
		} catch (Exception e) {
			// test if an exception is caught
			Assert.assertNotNull(e);
			// test type of exception caught
			Assert.assertTrue(e instanceof SalesTaxApplicationException);
		}
	}

}
