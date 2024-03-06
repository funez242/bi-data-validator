package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class External server error exception.
 */
public class ExternalServerErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new External server error exception.
     *
     * @param system  the system
     * @param message the message
     */
    public ExternalServerErrorException(String system, String message) {
		super("Error of communication with system: " + system + ", message: " + message);
	}

    /**
     * Instantiates a new External server error exception.
     *
     * @param message the message
     */
    public ExternalServerErrorException(String message) {
		super(message);
	}
}
