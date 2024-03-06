package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class Resource already exists exception.
 */
public class ResourceAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Resource already exists exception.
     *
     * @param message the message
     */
    public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
