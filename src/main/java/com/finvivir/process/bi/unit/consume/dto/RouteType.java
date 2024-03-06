package com.finvivir.process.bi.unit.consume.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of route depending on the frequency of the holder's visit to the central offices
 */
public enum RouteType {
    /**
     * Local route type.
     */
    LOCAL("LOCAL"),
    /**
     * Foreign route type.
     */
    FOREIGN("FOREIGN"),
    /**
     * Semi foreign route type.
     */
    SEMI_FOREIGN("SEMI-FOREIGN");

  private String value;

  RouteType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

    /**
     * From value route type.
     *
     * @param text the text
     * @return the route type
     */
    @JsonCreator
  public static RouteType fromValue(String text) {
    for (RouteType b : RouteType.values()) {
      if (String.valueOf(b.value).equals(text.toUpperCase())) {
        return b;
      }
    }
    return null;
  }
}
