package com.finvivir.process.bi.unit.business;

import com.finvivir.process.bi.unit.consume.ToolfiappBackendConsumer;
import com.finvivir.process.bi.unit.consume.dto.*;
import com.finvivir.process.bi.unit.provide.dto.ValidatedData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DataValidatorServiceTest {

    @Mock
    ToolfiappBackendConsumer toolfiappBackendConsumer;

    @InjectMocks
    DataValidatorService dataValidatorService;

    @Test
    void validateBusinessData() {
        RouteToOperateDto routDto = getRouteToOperate();
        when(toolfiappBackendConsumer.getGroupsofRoute("MEX", "2024-03-01")).thenReturn(routDto);


        PagePersonBusinessDataResultDto businessData = getBusinessPersonData();
        when(toolfiappBackendConsumer.getPersonsBusinessData("MEX", "CVMPUE01", 0, 5000,
                LocalDate.of(2024, 3, 1))).thenReturn(businessData);


        ResultListDto<ClientScoreDto> scoreDtoResultListDto = getScoreData(23317);
        when(toolfiappBackendConsumer.getPersonsScoreByGroup("MEX", 23317, 2)).thenReturn(scoreDtoResultListDto);

        ResultListDto<ClientScoreDto> scoreDtoResultListDto2 = getScoreData(27632);
        when(toolfiappBackendConsumer.getPersonsScoreByGroup("MEX", 27632, 2)).thenReturn(scoreDtoResultListDto2);

        ValidatedData result = dataValidatorService.getValidatedBusinessData("MEX", LocalDate.of(2024, 3, 1));


        Set<Integer> idsEnLos3Lados = new HashSet<>();
        idsEnLos3Lados.add(6145);
        idsEnLos3Lados.add(5852);
        idsEnLos3Lados.add(10);
        Set<Integer> idsSinBusiness = new HashSet<>();
        idsSinBusiness.add(5124);
        idsSinBusiness.add(5123);
        idsSinBusiness.add(7201);
        idsSinBusiness.add(7203);
        idsSinBusiness.add(7205);
        idsSinBusiness.add(21);
        idsSinBusiness.add(20);
        Set<Integer> idsSinScore = new HashSet<>();
        idsSinScore.add(5123);
        idsSinScore.add(7201);
        idsSinScore.add(7203);
        idsSinScore.add(7205);
        idsSinScore.add(20);
        Set<Integer> idsSinAmbos = new HashSet<>();
        idsSinAmbos.add(5123);
        idsSinAmbos.add(7201);
        idsSinAmbos.add(7203);
        idsSinAmbos.add(7205);
        idsSinAmbos.add(20);

        assertEquals(idsEnLos3Lados.size(), result.getPersonasEnLos3lados().size());
        assertTrue(idsEnLos3Lados.containsAll(result.getPersonasEnLos3lados()));

        assertEquals(idsSinBusiness.size(), result.getPersonasSinBusiness().size());
        assertTrue(idsSinBusiness.containsAll(result.getPersonasSinBusiness()));

        assertEquals(idsSinScore.size(), result.getPersonasSinScore().size());
        assertTrue(idsSinScore.containsAll(result.getPersonasSinScore()));

        assertEquals(idsSinAmbos.size(), result.getPersonasSinAmbos().size());
        assertTrue(idsSinAmbos.containsAll(result.getPersonasSinAmbos()));
    }

    private RouteToOperateDto getRouteToOperate(){
        RouteToOperateDto routDto = new RouteToOperateDto();
        routDto.setRouteCode("CVMPUE01");
        List<RouteToOperateDto.GroupToOperateDto> operateDtos = new ArrayList<>();
        RouteToOperateDto.GroupToOperateDto group1= new RouteToOperateDto.GroupToOperateDto();
        group1.setId(23317);

        PaymentDto paymentDto1 = PaymentDto.builder().clientId("5123").build();
        PaymentDto paymentDto2 = PaymentDto.builder().clientId("5124").build();
        PaymentDto paymentDto3 = PaymentDto.builder().clientId("5852").build();
        PaymentDto paymentDto4 = PaymentDto.builder().clientId("6145").build();
        PaymentDto paymentDto5 = PaymentDto.builder().clientId("7201").build();
        PaymentDto paymentDto6 = PaymentDto.builder().clientId("7203").build();
        PaymentDto paymentDto7 = PaymentDto.builder().clientId("7205").build();

        List<PaymentDto> paymentDtos = new ArrayList<>();
        paymentDtos.add(paymentDto1);
        paymentDtos.add(paymentDto2);
        paymentDtos.add(paymentDto3);
        paymentDtos.add(paymentDto4);
        paymentDtos.add(paymentDto5);
        paymentDtos.add(paymentDto6);
        paymentDtos.add(paymentDto7);
        group1.setPayments(paymentDtos);
        operateDtos.add(group1);

        RouteToOperateDto.GroupToOperateDto group2= new RouteToOperateDto.GroupToOperateDto();
        group2.setId(27632);
        PaymentDto payment2Dto1 = PaymentDto.builder().clientId("21").build();
        PaymentDto payment2Dto2 = PaymentDto.builder().clientId("10").build();
        PaymentDto payment2Dto3 = PaymentDto.builder().clientId("20").build();

        List<PaymentDto> payment2Dtos = new ArrayList<>();
        payment2Dtos.add(payment2Dto1);
        payment2Dtos.add(payment2Dto2);
        payment2Dtos.add(payment2Dto3);
        group2.setPayments(payment2Dtos);
        operateDtos.add(group2);

        routDto.setGroups(operateDtos);
        return routDto;
    }

    private PagePersonBusinessDataResultDto getBusinessPersonData(){
        PagePersonBusinessDataResultDto pagePersonBusinessDataResultDto = new PagePersonBusinessDataResultDto();

        PersonBusinessDataDto person2 = PersonBusinessDataDto.builder().personId(6145L).build();
        PersonBusinessDataDto person1 = PersonBusinessDataDto.builder().personId(5852L).build();
        PersonBusinessDataDto person3 = PersonBusinessDataDto.builder().personId(10L).build();

        List<PersonBusinessDataDto> personBusinessDataDtos = new ArrayList<>();
        personBusinessDataDtos.add(person1);
        personBusinessDataDtos.add(person2);
        personBusinessDataDtos.add(person3);

        pagePersonBusinessDataResultDto.setResults(personBusinessDataDtos);
        return pagePersonBusinessDataResultDto;
    }

    private ResultListDto<ClientScoreDto> getScoreData(int groupId){
        ResultListDto<ClientScoreDto> scoreDtoResultListDto = new ResultListDto<>(new ArrayList<>());
        if(groupId == 23317){
            ClientScoreDto clientScoreDto1 =  ClientScoreDto.builder().clientId(6145).build();
            ClientScoreDto clientScoreDto2 =  ClientScoreDto.builder().clientId(5852).build();
            ClientScoreDto clientScoreDto3 =  ClientScoreDto.builder().clientId(5124).build();
            scoreDtoResultListDto.getResults().add(clientScoreDto1);
            scoreDtoResultListDto.getResults().add(clientScoreDto2);
            scoreDtoResultListDto.getResults().add(clientScoreDto3);
        }else{
            ClientScoreDto clientScoreDto4 =  ClientScoreDto.builder().clientId(10).build();
            ClientScoreDto clientScoreDto5 =  ClientScoreDto.builder().clientId(21).build();
            scoreDtoResultListDto.getResults().add(clientScoreDto4);
            scoreDtoResultListDto.getResults().add(clientScoreDto5);
        }

        return scoreDtoResultListDto;
    }
}
