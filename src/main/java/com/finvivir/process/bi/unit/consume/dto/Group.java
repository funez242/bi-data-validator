package com.finvivir.process.bi.unit.consume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group { // this entity is given from /groups from commercial management service

	private Integer id;
	
	private String name;
	
	private String operationDay;
}
