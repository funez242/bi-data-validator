package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class Internal server error exception.
 */
public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 9081628371234007391L;

    /**
     * Instantiates a new Internal server error exception.
     *
     * @param message the message
     */
    public InternalServerErrorException(String message) { // message to show in service
		super(message);
	}
}
