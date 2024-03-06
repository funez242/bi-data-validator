package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

import jakarta.annotation.Generated;

/**
 * The class Not found exception.
 */
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-08-31T15:59:33.052680500-05:00[America/Mexico_City]")
public class NotFoundException extends Exception {
    
	private static final long serialVersionUID = -5538685475122502646L;

    /**
     * Instantiates a new Not found exception.
     *
     * @param msg the msg
     */
    public NotFoundException (String msg) {
        super(msg);
    }
}

