package com.finvivir.process.bi.unit.consume.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Set of clients operated by a group leader
 * Description: system-commercial-management client´s request
 */
@Schema(description = "Set of clients operated by a group leader")
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-08-12T15:35:48.186127900-05:00[America/Mexico_City]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Groups {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("operationDay")
  private WorkingDayOfWeek operationDay;

  @JsonProperty("status")
  private OperationalStatus status;

  @JsonProperty("closingReason")
  private String closingReason;

  @JsonProperty("netsuiteId")
  private Integer netsuiteId;

  @JsonProperty("multiGroup")
  private Boolean multiGroup;

  @JsonProperty("routeCode")
  private String routeCode;
  
  @JsonProperty("registrationDate")
  @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
  private LocalDate registrationDate;
  
  @JsonProperty("pncId")
  private Integer pncId;
  
  @JsonProperty("origin")
  private String origin;
  
  @JsonProperty("type")
  private RouteType type;

    /**
     * Id groups.
     *
     * @param id the id
     * @return the groups
     */
    public Groups id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of group
   * @return id
   **/
  @Schema(example = "145", accessMode = Schema.AccessMode.READ_ONLY, description = "Identifier of group")
      @NotNull

    public Integer getId() {
    return id;
  }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
    this.id = id;
  }

    /**
     * Name groups.
     *
     * @param name the name
     * @return the groups
     */
    public Groups name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Group name
   * @return name
   **/
  @Schema(example = "Tequila", description = "Group name")
      @NotNull

  @Size(min=3,max=50)   public String getName() {
    return name;
  }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
    this.name = name;
  }

    /**
     * Operation day groups.
     *
     * @param operationDay the operation day
     * @return the groups
     */
    public Groups operationDay(WorkingDayOfWeek operationDay) {
    this.operationDay = operationDay;
    return this;
  }

  /**
   * Get operationDay
   * @return operationDay
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public WorkingDayOfWeek getOperationDay() {
    return operationDay;
  }

    /**
     * Sets operation day.
     *
     * @param operationDay the operation day
     */
    public void setOperationDay(WorkingDayOfWeek operationDay) {
    this.operationDay = operationDay;
  }

    /**
     * Status groups.
     *
     * @param status the status
     * @return the groups
     */
    public Groups status(OperationalStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public OperationalStatus getStatus() {
    return status;
  }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(OperationalStatus status) {
    this.status = status;
  }

    /**
     * Closing reason groups.
     *
     * @param closingReason the closing reason
     * @return the groups
     */
    public Groups closingReason(String closingReason) {
    this.closingReason = closingReason;
    return this;
  }

  /**
   * Reason why the group is inactive (FALCO, unsafety, etc.)
   * @return closingReason
   **/
  @Schema(example = "unsafety", description = "Reason why the group is inactive (FALCO, unsafety, etc.)")
  
  @Size(min=3,max=50)   public String getClosingReason() {
    return closingReason;
  }

    /**
     * Sets closing reason.
     *
     * @param closingReason the closing reason
     */
    public void setClosingReason(String closingReason) {
    this.closingReason = closingReason;
  }

    /**
     * Netsuite id groups.
     *
     * @param netsuiteId the netsuite id
     * @return the groups
     */
    public Groups netsuiteId(Integer netsuiteId) {
    this.netsuiteId = netsuiteId;
    return this;
  }

  /**
   * Identifier of group in NetSuite system
   * @return netsuiteId
   **/
  @Schema(example = "415", description = "Identifier of group in NetSuite system")
      @NotNull

    public Integer getNetsuiteId() {
    return netsuiteId;
  }

    /**
     * Sets netsuite id.
     *
     * @param netsuiteId the netsuite id
     */
    public void setNetsuiteId(Integer netsuiteId) {
    this.netsuiteId = netsuiteId;
  }

    /**
     * Multi group groups.
     *
     * @param multiGroup the multi group
     * @return the groups
     */
    public Groups multiGroup(Boolean multiGroup) {
    this.multiGroup = multiGroup;
    return this;
  }

  /**
   * True if it is a split group, else false
   * @return multiGroup
   **/
  @Schema(example = "false", description = "True if it is a split group, else false")
  
    public Boolean isMultiGroup() {
    return multiGroup;
  }

    /**
     * Sets multi group.
     *
     * @param multiGroup the multi group
     */
    public void setMultiGroup(Boolean multiGroup) {
    this.multiGroup = multiGroup;
  }

    /**
     * Route code groups.
     *
     * @param routeCode the route code
     * @return the groups
     */
    public Groups routeCode(String routeCode) {
    this.routeCode = routeCode;
    return this;
  }

  /**
   * Code of the route to which the group belongs
   * @return routeCode
   **/
  @Schema(example = "CVMJAL01", description = "Code of the route to which the group belongs")
      @NotNull

  @Size(min=8,max=8)   public String getRouteCode() {
    return routeCode;
  }

    /**
     * Sets route code.
     *
     * @param routeCode the route code
     */
    public void setRouteCode(String routeCode) {
    this.routeCode = routeCode;
  }

    /**
     * Registration date groups.
     *
     * @param registrationDate the registration date
     * @return the groups
     */
    public Groups registrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
    return this;
  }

  /**
   * Group registration date
   * @return registrationDate
   **/
  @Schema(example = "2022-09-05", description = "Group registration date")
      @NotNull

    @Valid
    public LocalDate getRegistrationDate() {
    return registrationDate;
  }

    /**
     * Sets registration date.
     *
     * @param registrationDate the registration date
     */
    public void setRegistrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
  }

    /**
     * Pnc id groups.
     *
     * @param pncId the pnc id
     * @return the groups
     */
    public Groups pncId(Integer pncId) {
    this.pncId = pncId;
    return this;
  }

  /**
   * Identifier of pnc to save in NetSuite system
   * @return pncId
   **/
  @Schema(example = "536125", description = "Identifier of pnc to save in NetSuite system")
      @NotNull

    public Integer getPncId() {
    return pncId;
  }

    /**
     * Sets pnc id.
     *
     * @param pncId the pnc id
     */
    public void setPncId(Integer pncId) {
    this.pncId = pncId;
  }

    /**
     * Origin groups.
     *
     * @param origin the origin
     * @return the groups
     */
    public Groups origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Value than indicates the data origin (TOOLFIWEB,CARFIN)
   * @return origin
   **/
  @Schema(example = "TOOLFIWEB", description = "Value than indicates the data origin (TOOLFIWEB,CARFIN)")
      @NotNull

  @Size(min=8,max=8)   public String getOrigin() {
    return origin;
  }

    /**
     * Sets origin.
     *
     * @param origin the origin
     */
    public void setOrigin(String origin) {
    this.origin = origin;
  }
  
  /**
   * Get type
   * @return type
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public RouteType getType() {
    return type;
  }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(RouteType type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Groups group = (Groups) o;
    return Objects.equals(this.id, group.id) &&
        Objects.equals(this.name, group.name) &&
        Objects.equals(this.operationDay, group.operationDay) &&
        Objects.equals(this.status, group.status) &&
        Objects.equals(this.closingReason, group.closingReason) &&
        Objects.equals(this.netsuiteId, group.netsuiteId) &&
        Objects.equals(this.multiGroup, group.multiGroup) &&
        Objects.equals(this.routeCode, group.routeCode) &&
        Objects.equals(this.registrationDate, group.registrationDate) &&
        Objects.equals(this.pncId, group.pncId) &&
        Objects.equals(this.type, group.getType()) &&
        Objects.equals(this.origin, group.origin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, operationDay, status, closingReason, netsuiteId, multiGroup, routeCode, registrationDate, pncId, origin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    operationDay: ").append(toIndentedString(operationDay)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    closingReason: ").append(toIndentedString(closingReason)).append("\n");
    sb.append("    netsuiteId: ").append(toIndentedString(netsuiteId)).append("\n");
    sb.append("    multiGroup: ").append(toIndentedString(multiGroup)).append("\n");
    sb.append("    routeCode: ").append(toIndentedString(routeCode)).append("\n");
    sb.append("    registrationDate: ").append(toIndentedString(registrationDate)).append("\n");
    sb.append("    pncId: ").append(toIndentedString(pncId)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
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
