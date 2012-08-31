package com.thoughtworks.salestax;

public class Item {
	private String name;
	private Catagory catagory;
	private Float unitPrice;
	private Boolean isImported;
	
	public Item(String name, String catagoryStr, Float unitPrice,  String type) {		
		super();
		this.name = name;
		if (catagoryStr.equals("FOOD"))
			this.catagory = Catagory.FOOD;
		else if (catagoryStr.equals("BOOK"))
			this.catagory = Catagory.BOOK;
		else if (catagoryStr.equals("MEDICAL"))
			this.catagory = Catagory.MEDICAL;
		else if (catagoryStr.equals("OTHER"))
			this.catagory = Catagory.OTHER;
		this.unitPrice = unitPrice;
		this.isImported = type.equalsIgnoreCase("import") ? true : false; 
	}

	public String getName() {
		return name;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}
	
	public Boolean getIsImported() {
		return isImported;
	}
}
