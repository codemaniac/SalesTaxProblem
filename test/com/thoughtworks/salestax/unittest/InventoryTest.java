package com.thoughtworks.salestax.unittest;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.salestax.Inventory;
import com.thoughtworks.salestax.Item;

/**
 * InventoryTest
 * 
 * Unit test cases for com.thoughtworks.salestax.Inventory
 * 
 * @author codemaniac
 *
 */
public class InventoryTest {

	/**
	 * unit test for getItem method
	 */
	@Test
	public void testGetItem() {		
		try {
			// load inventory XML file
			File inventoryXML = new File("/home/codemaniac/Projects/SalesTaxProblem/src/com/thoughtworks/salestax/items.xml");
			// create inventory
			Inventory testObj = new Inventory(inventoryXML);
			// test if an existing inventory item is successfully got
			Assert.assertNotNull(testObj.getItem("book"));
			// test if a non-existing inventory item is got
			Assert.assertNull(testObj.getItem("fish"));
			// test the type of the obtained object
			Object testResult = testObj.getItem("music CD");
			Assert.assertTrue(testResult instanceof Item);
		} catch (Exception e) {
			// no exceptions is to be caught.
			// if an exception is caught, fail the test
			fail("Something went wrong! Expected no exceptions but got one !");
		}
		
		try {
			// create a non-existant file object
			File noFile = new File("nosuchfileexists.txt");
			// create inventory
			Inventory testObj = new Inventory(noFile);
			// if no exception is thrown at this point, fail the test
			fail("Something went wrong! Expected IOException but got none !");
		} catch (Exception e) {
			// test if an exception is caught
			Assert.assertNotNull(e);
			// test type of exception caught
			Assert.assertTrue(e instanceof IOException);
		}
		
	}

}
