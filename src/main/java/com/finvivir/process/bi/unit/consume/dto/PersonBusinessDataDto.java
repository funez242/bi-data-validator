package com.finvivir.process.bi.unit.consume.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "PersonBusinessData", description = "Basic information of person business data")
public class PersonBusinessDataDto { // this entity is given from /v1/routes/{routeCode}/personBusinessData from process bi unit service
	
	@Schema(name = "personId", description = "Identifier of person", example = "23")
	private Long personId;
	
	@Schema(name = "isNominee", description = "true if person is nominee in finvivir", example = "true")
	private Boolean isNominee;
	
	@Schema(name = "penaltiesByBrand", description = "Number of penaltiesByBrand of person", example = "1")
	private Integer penaltiesByBrand;
	
	@Schema(name = "globalPenalties", description = "Number of globalPenalties of person", example = "0")
	private Integer globalPenalties;
	
	@Schema(name = "latePaymentsByBrand", description = "Number of latePaymentsByBrand of person", example = "2")
	private Integer latePaymentsByBrand;
	
	@Schema(name = "globalLatePayments", description = "Number of globalLatePayments of person", example = "1")
	private Integer globalLatePayments;
	
	@Schema(name = "brandRelationships", description = "Number of brandRelationships of person", example = "0")
	private Integer brandRelationships;
	
	@Schema(name = "globalRelationships", description = "Number of globalRelationships of person", example = "0")
	private Integer globalRelationships;
}
