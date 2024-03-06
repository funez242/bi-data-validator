package com.finvivir.process.bi.unit.consume;


import com.finvivir.process.bi.unit.consume.client.ToolfiappBackendClient;
import com.finvivir.process.bi.unit.consume.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;


import java.time.LocalDate;

/**
 * The class System commercial management consumer.
 * Description: system-commercial-management client impl
 */
@Service
@Slf4j
public class ToolfiappBackendConsumer {

	private final ToolfiappBackendClient toolfiappBackendClient;

	@Autowired
	public ToolfiappBackendConsumer(ToolfiappBackendClient toolfiappBackendClient) {
		this.toolfiappBackendClient = toolfiappBackendClient;
	}
	public RouteToOperateDto getGroupsofRoute(String countryCode, String operationDate){
		return toolfiappBackendClient.getGroupsofRoute(countryCode,operationDate).getBody();
	}

	public PagePersonBusinessDataResultDto getPersonsBusinessData(
			String countryCode,
			String routeCode,
			Integer page,
			Integer size,
			LocalDate operationDate
	){
		return toolfiappBackendClient.getPersonsBusinessData(countryCode,routeCode,page,size,operationDate).getBody();
	}

	public ResultListDto<ClientScoreDto> getPersonsScoreByGroup(
			String countryCode,
			Integer groupId,
			Integer idScoreV2){
		return this.toolfiappBackendClient.getPersonsScoreByGroup(countryCode,groupId,idScoreV2).getBody();
	}


}
