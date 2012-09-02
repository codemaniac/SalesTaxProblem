package com.thoughtworks.salestax;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.thoughtworks.salestax.unittest.InventoryTest;
import com.thoughtworks.salestax.unittest.ItemTest;
import com.thoughtworks.salestax.unittest.ReceiptGeneratorTest;
import com.thoughtworks.salestax.unittest.SalesAndImportTaxCalculatorTest;

/**
 * SalesTaxTestSuite
 * 
 * Test suite
 * 
 * @author codemaniac
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ReceiptGeneratorTest.class,
		SalesAndImportTaxCalculatorTest.class, InventoryTest.class, ItemTest.class })
public class SalesTaxTestSuite {

}
