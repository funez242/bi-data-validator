package com.finvivir.process.bi.unit.consume.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Schema(name = "ResultList", description = "List of generic type")
public class ResultListDto<T> { // list of generic type

	private List<T> results;

	public ResultListDto(List<T> list) {
		this.results = list;
	}

	public List<T> getResults() {
		return results;
	}

}