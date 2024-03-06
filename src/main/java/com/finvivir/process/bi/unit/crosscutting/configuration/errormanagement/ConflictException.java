package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class Conflict exception.
 */
public class ConflictException extends IllegalArgumentException {

	private static final long serialVersionUID = 7891628371234007661L;

    /**
     * Instantiates a new Conflict exception.
     *
     * @param message the message
     */
    public ConflictException(String message) { // message to show in service
		super(message);
	}
}
