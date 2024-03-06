package com.finvivir.process.bi.unit.consume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route { // this entity is given from /routes/{routeCode} from commercial management

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class RouteParents { 
		
		private String brandCode;
		
	}
	
	private String code;
	
	private String regionCode;
	
	private RouteParents parents;
}
