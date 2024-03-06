package com.finvivir.process.bi.unit.provide.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Set of clients operated by a group leader
 */
@Getter
@Setter
@Schema(description = "Set of persons by a route code")
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-08-12T15:35:48.186127900-05:00[America/Mexico_City]")
@Builder
public class Person {
  @JsonProperty("id")
  private String id;
  @JsonProperty("personId")
  private Long personId;
  @JsonProperty("brandCode")
  private String brandCode;
  @JsonProperty("isNominee")
  private Boolean isNominee;
  @JsonProperty("penaltiesByBrand")
  private Integer penaltiesByBrand;
  @JsonProperty("globalPenalties")
  private Integer globalPenalties;
  @JsonProperty("latePaymentsByBrand")
  private Integer latePaymentsByBrand;
  @JsonProperty("globalLatePayments")
  private Integer globalLatePayments;
  @JsonProperty("brandRelationships")
  private Integer brandRelationships;
  @JsonProperty("globalRelationships")
  private Integer globalRelationships;
  @JsonProperty("groupIds")
  private List<Integer> groupIds;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    personId: ").append(toIndentedString(personId)).append("\n");
    sb.append("    brandCode: ").append(toIndentedString(brandCode)).append("\n");
    sb.append("    isNominee: ").append(toIndentedString(isNominee)).append("\n");
    sb.append("    penaltiesByBrand: ").append(toIndentedString(penaltiesByBrand)).append("\n");
    sb.append("    globalPenalties: ").append(toIndentedString(globalPenalties)).append("\n");
    sb.append("    latePaymentsByBrand: ").append(toIndentedString(latePaymentsByBrand)).append("\n");
    sb.append("    globalLatePayments: ").append(toIndentedString(globalLatePayments)).append("\n");
    sb.append("    brandRelationships: ").append(toIndentedString(brandRelationships)).append("\n");
    sb.append("    globalRelationships: ").append(toIndentedString(globalRelationships)).append("\n");
    sb.append("    groupIds: ").append(toIndentedString(groupIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
