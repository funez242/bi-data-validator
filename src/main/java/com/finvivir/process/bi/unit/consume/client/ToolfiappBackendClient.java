package com.finvivir.process.bi.unit.consume.client;

import com.finvivir.process.bi.unit.consume.dto.ClientScoreDto;
import com.finvivir.process.bi.unit.consume.dto.PagePersonBusinessDataResultDto;
import com.finvivir.process.bi.unit.consume.dto.ResultListDto;
import com.finvivir.process.bi.unit.consume.dto.RouteToOperateDto;
import com.finvivir.process.bi.unit.crosscutting.configuration.FeignClientInterceptor;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * The interface System commercial management client.
 * Description: system-commercial-management Feign client
 */
@FeignClient(name = "toolfiapp-backend", url = "${TOOLFIAPP-BACKEND_SERVICE_URL}", configuration = FeignClientInterceptor.class)
public interface ToolfiappBackendClient {
	
	/**
	 * Client for to get groups - get groups
	 *
	 * @param countryCode
	 * @param operationDate
	 * @return 	ResponseEntity<Product>
	 */
	@GetMapping(path = "/v1/groups", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RouteToOperateDto> getGroupsofRoute(
			@RequestHeader("X-Request-Country") String countryCode,
			@RequestParam("operationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String operationDate);

	@GetMapping(path = "/v1/personBusinessData", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PagePersonBusinessDataResultDto> getPersonsBusinessData(
			@RequestHeader("X-Request-Country") String countryCode,
			@RequestParam("routeCode") String routeCode,
			@RequestParam("page") Integer page,
			@RequestParam("size") Integer size,
			@RequestParam("operationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate operationDate
	);

	@GetMapping(path = "/v1/personsScores", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResultListDto<ClientScoreDto>> getPersonsScoreByGroup(
			@RequestHeader("X-Request-Country") String countryCode,
			@RequestParam("groupId") Integer groupId,
			@RequestHeader("X-Score-Version") Integer idScoreV2);
}
