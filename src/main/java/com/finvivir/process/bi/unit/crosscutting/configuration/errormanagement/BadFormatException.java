package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class Bad format exception.
 */
public class BadFormatException extends IllegalArgumentException {

	private static final long serialVersionUID = 1546749511327007391L;

    /**
     * Instantiates a new Bad format exception.
     *
     * @param message the message
     */
    public BadFormatException(String message) {
		super(message);
	}
}