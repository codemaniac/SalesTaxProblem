package com.thoughtworks.salestax;

public enum Catagory {
	FOOD(false), BOOK(false), MEDICAL(false), OTHER(true);

	private Boolean isTaxable;

	private Catagory(Boolean b) {
		isTaxable = b;
	}

	public Boolean getIsTaxable() {
		return isTaxable;
	}
}
