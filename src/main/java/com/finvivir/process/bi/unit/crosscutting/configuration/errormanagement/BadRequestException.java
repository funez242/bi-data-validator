package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class Bad request exception.
 */
public class BadRequestException extends IllegalArgumentException {

	private static final long serialVersionUID = 4561628371234007391L;

    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     */
    public BadRequestException(String message) { // message to show in service
		super(message);
	}
}
