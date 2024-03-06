package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

/**
 * The class Object not found exception.
 */
public class ObjectNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 3411628371234237644L;

    /**
     * Instantiates a new Object not found exception.
     *
     * @param message the message
     */
    public ObjectNotFoundException(String message) {
		super(message);
	}

    /**
     * Instantiates a new Object not found exception.
     */
    public ObjectNotFoundException() {
		super();
	}
	
}
