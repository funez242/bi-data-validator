package com.finvivir.process.bi.unit.consume.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Working days of the week in finvivir (MONDAY, TUESDAY, ..., SATURDAY)
 */
public enum WorkingDayOfWeek {
    /**
     * Monday working day of week.
     */
    MONDAY("MONDAY"),
    /**
     * Tuesday working day of week.
     */
    TUESDAY("TUESDAY"),
    /**
     * Wednesday working day of week.
     */
    WEDNESDAY("WEDNESDAY"),
    /**
     * Thursday working day of week.
     */
    THURSDAY("THURSDAY"),
    /**
     * Friday working day of week.
     */
    FRIDAY("FRIDAY"),
    /**
     * Saturday working day of week.
     */
    SATURDAY("SATURDAY");

  private String value;

  WorkingDayOfWeek(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

    /**
     * From value working day of week.
     *
     * @param text the text
     * @return the working day of week
     */
    @JsonCreator
  public static WorkingDayOfWeek fromValue(String text) {
    for (WorkingDayOfWeek b : WorkingDayOfWeek.values()) {
      if (String.valueOf(b.value).equalsIgnoreCase(text)) {
        return b;
      }
    }
    return null;
  }
}
