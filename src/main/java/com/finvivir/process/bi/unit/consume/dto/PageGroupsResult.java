package com.finvivir.process.bi.unit.consume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Generated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PageGroupsResult
 * Description: system-commercial-management request paging.
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-08-12T15:35:48.186127900-05:00[America/Mexico_City]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageGroupsResult   {
  @JsonProperty("currentPage")
  private Integer currentPage;

  @JsonProperty("resultsInPage")
  private Integer resultsInPage;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("totalResults")
  private Long totalResults;

  @JsonProperty("results")
  @Valid
  private List<Groups> results;

    /**
     * Current page page groups result.
     *
     * @param currentPage the current page
     * @return the page groups result
     */
    public PageGroupsResult currentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return this;
  }

  /**
   * Current page result returned
   * @return currentPage
   **/
  @Schema(example = "0", description = "Current page result returned")
      @NotNull

    public Integer getCurrentPage() {
    return currentPage;
  }

    /**
     * Sets current page.
     *
     * @param currentPage the current page
     */
    public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

    /**
     * Results in page page groups result.
     *
     * @param resultsInPage the results in page
     * @return the page groups result
     */
    public PageGroupsResult resultsInPage(Integer resultsInPage) {
    this.resultsInPage = resultsInPage;
    return this;
  }

  /**
   * Total results returned in current page
   * @return resultsInPage
   **/
  @Schema(example = "200", description = "Total results returned in current page")
      @NotNull

    public Integer getResultsInPage() {
    return resultsInPage;
  }

    /**
     * Sets results in page.
     *
     * @param resultsInPage the results in page
     */
    public void setResultsInPage(Integer resultsInPage) {
    this.resultsInPage = resultsInPage;
  }

    /**
     * Total pages page groups result.
     *
     * @param totalPages the total pages
     * @return the page groups result
     */
    public PageGroupsResult totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Total pages required to complete search
   * @return totalPages
   **/
  @Schema(example = "6", description = "Total pages required to complete search")
      @NotNull

    public Integer getTotalPages() {
    return totalPages;
  }

    /**
     * Sets total pages.
     *
     * @param totalPages the total pages
     */
    public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

    /**
     * Total results page groups result.
     *
     * @param totalResults the total results
     * @return the page groups result
     */
    public PageGroupsResult totalResults(Long totalResults) {
    this.totalResults = totalResults;
    return this;
  }

  /**
   * Total results in complete search
   * @return totalResults
   **/
  @Schema(example = "1134", description = "Total results in complete search")
      @NotNull

    public Long getTotalResults() {
    return totalResults;
  }

    /**
     * Sets total results.
     *
     * @param totalResults the total results
     */
    public void setTotalResults(Long totalResults) {
    this.totalResults = totalResults;
  }

    /**
     * Results page groups result.
     *
     * @param results the results
     * @return the page groups result
     */
    public PageGroupsResult results(List<Groups> results) {
    this.results = results;
    return this;
  }

    /**
     * Add results item page groups result.
     *
     * @param resultsItem the results item
     * @return the page groups result
     */
    public PageGroupsResult addResultsItem(Groups resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Objects in current page response
   * @return results
   **/
  @Schema(example = "[]", description = "Objects in current page response")
      @Valid
    public List<Groups> getResults() {
    return results;
  }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(List<Groups> results) {
    this.results = results;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageGroupsResult pageGroupsResult = (PageGroupsResult) o;
    return Objects.equals(this.currentPage, pageGroupsResult.currentPage) &&
        Objects.equals(this.resultsInPage, pageGroupsResult.resultsInPage) &&
        Objects.equals(this.totalPages, pageGroupsResult.totalPages) &&
        Objects.equals(this.totalResults, pageGroupsResult.totalResults) &&
        Objects.equals(this.results, pageGroupsResult.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPage, resultsInPage, totalPages, totalResults, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageGroupsResult {\n");
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
    sb.append("    resultsInPage: ").append(toIndentedString(resultsInPage)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
