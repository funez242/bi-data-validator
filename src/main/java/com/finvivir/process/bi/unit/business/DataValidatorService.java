package com.finvivir.process.bi.unit.business;

import com.finvivir.process.bi.unit.consume.ToolfiappBackendConsumer;
import com.finvivir.process.bi.unit.consume.dto.*;
import com.finvivir.process.bi.unit.provide.dto.ValidatedData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class PersonService.
 * Description: Service Class Person Domain
 *
 */
@Service
@Slf4j
public class DataValidatorService {
    private final ToolfiappBackendConsumer toolfiappBackendConsumer;

    /**
     * Instantiates a new Person service.
     *
     * @param toolfiappBackendConsumer the toolfi app backend consumer
     */
    @Autowired
    public DataValidatorService(ToolfiappBackendConsumer toolfiappBackendConsumer) {
        this.toolfiappBackendConsumer = toolfiappBackendConsumer;
    }

    /**
     * Method: getValidatedBusinessData
     * Description: business logic
     * @return ValidateData
     */
    public ValidatedData getValidatedBusinessData(String countryCode, LocalDate operationDate) {
        log.info(String.format("countryCode: %s, operationDate: %s",countryCode,operationDate));

        RouteToOperateDto getGroupResponse =
                toolfiappBackendConsumer.getGroupsofRoute(countryCode,operationDate.toString());
        log.info(getGroupResponse.toString());

        Set<Integer> groupIds = getGroupResponse.getGroups().stream().filter(group -> group.getPayments()!=null && !group.getPayments().isEmpty())
                .map(RouteToOperateDto.GroupToOperateDto::getId).collect(Collectors.toSet());

        log.info("groupIds: {}",groupIds);

        Set<Integer> groupPersonIds = getGroupResponse.getGroups().stream().filter(group ->
                         group.getPayments()!=null && !group.getPayments().isEmpty())
                        .map(RouteToOperateDto.GroupToOperateDto::getPayments)
                        .flatMap(payments -> payments.stream().map(payment -> Integer.parseInt(payment.getClientId())))
                        .collect(Collectors.toSet());

        log.info("groupPersonIds: {}",groupPersonIds);

        PagePersonBusinessDataResultDto getPersonDataResponse =
                toolfiappBackendConsumer.getPersonsBusinessData(countryCode,
                        getGroupResponse.getRouteCode(),0,5000,operationDate);
        log.info(getPersonDataResponse.toString());

        Set<Long> businessIds = getPersonDataResponse.getResults().stream().map(PersonBusinessDataDto::getPersonId).collect(Collectors.toSet());

        log.info("businessIds: {}",businessIds);

        Stream<Integer> scoreIdsStream = groupIds.stream().flatMap(groupId -> {
             log.info("groupID: {}",groupId);
             ResultListDto<ClientScoreDto> scoreResponse = toolfiappBackendConsumer.getPersonsScoreByGroup(countryCode,groupId,2);
             log.info("ScoreResponse: {}",scoreResponse.getResults().toString());
             return scoreResponse.getResults()
                  .stream().map(ClientScoreDto::getClientId);
        });

        Set<Integer> scoreIds = scoreIdsStream.collect(Collectors.toSet());

        log.info("scoreIds: {}",scoreIds);
        List<Integer> idsEnLos3Lados = groupPersonIds.stream().filter(groupID ->
                businessIds.contains(Long.valueOf(groupID)) && scoreIds.contains(groupID)).toList();

        List<Integer> idsSinBusiness = groupPersonIds.stream().filter(groupId ->
                !businessIds.contains(Long.valueOf(groupId))).toList();

        List<Integer> idsSinScore = groupPersonIds.stream().filter(groupId ->
                !scoreIds.contains(groupId)).toList();

        List<Integer> idsSinAmbos = groupPersonIds.stream().filter(groupID ->
                !businessIds.contains(Long.valueOf(groupID)) && !scoreIds.contains(groupID)).toList();

        log.info("{}:{}:{}:{}",idsEnLos3Lados,idsSinBusiness,idsSinScore,idsSinAmbos);
        ValidatedData response =  new ValidatedData();
        response.setPersonasSinBusiness(idsSinBusiness);
        response.setPersonasSinScore(idsSinScore);
        response.setPersonasSinAmbos(idsSinAmbos);
        response.setPersonasEnLos3lados(idsEnLos3Lados);


        return response;
    }

}
