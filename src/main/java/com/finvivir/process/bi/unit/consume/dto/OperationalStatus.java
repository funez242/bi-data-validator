package com.finvivir.process.bi.unit.consume.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Operational status.
 * Description: system-commercial-management group status.
 */
public enum OperationalStatus {
    /**
     * Active operational status.
     */
    ACTIVE("ACTIVE"),
    /**
     * Inactive operational status.
     */
    INACTIVE("INACTIVE");

	private String value;

	OperationalStatus(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

    /**
     * From value operational status.
     *
     * @param text the text
     * @return the operational status
     */
    @JsonCreator
	public static OperationalStatus fromValue(String text) {
		for (OperationalStatus b : OperationalStatus.values()) {
			if (String.valueOf(b.value).equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
