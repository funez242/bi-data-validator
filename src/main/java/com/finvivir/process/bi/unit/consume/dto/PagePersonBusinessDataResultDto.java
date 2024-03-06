package com.finvivir.process.bi.unit.consume.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "PagePersonBusinessDataResult", description = "Contains result of search in page")
public class PagePersonBusinessDataResultDto {

	@Schema(name = "currentPage", description = "Current page result returned", example = "0")
	private Integer currentPage;
	
	@Schema(name = "resultsInPage", description = "Total result returned in current page", example = "200")
	private Integer resultsInPage;
	
	@Schema(name = "totalPages", description = "Total pages required to complete search", example = "6")
	private Integer totalPages;
	
	@Schema(name = "totalResults", description = "Total results in complete search", example = "1134")
	private Long totalResults;

	@Builder.Default
	private List<PersonBusinessDataDto> results = new ArrayList<>();

}