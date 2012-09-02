package com.thoughtworks.salestax.exception;

/**
 * SalesTaxApplicationException
 * 
 * Custom exception for the application
 * 
 * @author codemaniac
 *
 */
public class SalesTaxApplicationException extends Exception {

	public SalesTaxApplicationException(String message) {
		super(message);
	}

	public SalesTaxApplicationException(Throwable cause) {
		super(cause);
	}

	public SalesTaxApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
