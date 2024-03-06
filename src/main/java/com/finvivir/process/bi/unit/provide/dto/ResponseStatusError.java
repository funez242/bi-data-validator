package com.finvivir.process.bi.unit.provide.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Error response
 */
@Schema(description = "Error response")
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-08-12T15:35:48.186127900-05:00[America/Mexico_City]")

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatusError {
  @JsonProperty("timestamp")
  private String timestamp = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("error")
  private String error = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("path")
  private String path = null;

    /**
     * Timestamp response status error.
     *
     * @param timestamp the timestamp
     * @return the response status error
     */
    public ResponseStatusError timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Time when the error occurred
   * @return timestamp
   **/
  @Schema(example = "2022-07-29T19:25:03.840+00:00", description = "Time when the error occurred")
  
    public String getTimestamp() {
    return timestamp;
  }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

    /**
     * Status response status error.
     *
     * @param status the status
     * @return the response status error
     */
    public ResponseStatusError status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Error ocurred in number
   * minimum: 100
   * maximum: 599
   * @return status
   **/
  @Schema(example = "404", description = "Error ocurred in number")
      @NotNull

  @Min(100) @Max(599)   public Integer getStatus() {
    return status;
  }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Integer status) {
    this.status = status;
  }

    /**
     * Error response status error.
     *
     * @param error the error
     * @return the response status error
     */
    public ResponseStatusError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Error ocurred
   * @return error
   **/
  @Schema(example = "Not Found", description = "Error ocurred")
  
    public String getError() {
    return error;
  }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(String error) {
    this.error = error;
  }

    /**
     * Message response status error.
     *
     * @param message the message
     * @return the response status error
     */
    public ResponseStatusError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Custom error message
   * @return message
   **/
  @Schema(example = "Server did not find the requested resource", description = "Custom error message")
      @NotNull

    public String getMessage() {
    return message;
  }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
    this.message = message;
  }

    /**
     * Path response status error.
     *
     * @param path the path
     * @return the response status error
     */
    public ResponseStatusError path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Endpoint where the error occurred
   * @return path
   **/
  @Schema(example = "/v1/groups", description = "Endpoint where the error occurred")
  
    public String getPath() {
    return path;
  }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
    this.path = path;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseStatusError responseStatusError = (ResponseStatusError) o;
    return Objects.equals(this.timestamp, responseStatusError.timestamp) &&
        Objects.equals(this.status, responseStatusError.status) &&
        Objects.equals(this.error, responseStatusError.error) &&
        Objects.equals(this.message, responseStatusError.message) &&
        Objects.equals(this.path, responseStatusError.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, status, error, message, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseStatusError {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
