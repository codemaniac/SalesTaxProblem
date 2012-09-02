package com.thoughtworks.salestax;

import com.thoughtworks.salestax.exception.SalesTaxApplicationException;

/**
 * Item
 * 
 * Holds the item's name, catagory and type - (local | imported)
 * 
 * @author codemaniac
 *
 */
public final class Item {
	
	/**  
	 * Catagories of Items
	 */
	static enum Catagory {
		FOOD(false), BOOK(false), MEDICAL(false), OTHER(true);
		
		private Boolean isTaxable;

		private Catagory(Boolean b) {
			isTaxable = b;
		}

		public Boolean getIsTaxable() {
			return isTaxable;
		}
	}
	
	private String name;
	private Catagory catagory;	
	private Boolean isImported;
	
	/**
	 * Creates an Item
	 * 
	 * @param name
	 * @param catagoryStr
	 * @param type
	 * @throws SalesTaxApplicationException
	 */
	public Item(String name, String catagoryStr, String type) throws SalesTaxApplicationException {		
		super();
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			throw new SalesTaxApplicationException("No item name specified !");
		}
		if (catagoryStr.equals("FOOD"))
			this.catagory = Catagory.FOOD;
		else if (catagoryStr.equals("BOOK"))
			this.catagory = Catagory.BOOK;
		else if (catagoryStr.equals("MEDICAL"))
			this.catagory = Catagory.MEDICAL;
		else if (catagoryStr.equals("OTHER"))
			this.catagory = Catagory.OTHER;
		else
			throw new SalesTaxApplicationException("No such item catagory !");		
		this.isImported = type.equalsIgnoreCase("import") ? true : false; 
	}

	public String getName() {
		return name;
	}

	public Catagory getCatagory() {
		return catagory;
	}
	
	public Boolean getIsImported() {
		return isImported;
	}
	
}
