package com.finvivir.process.bi.unit.consume.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
@Data
@Schema(name = "ClientScore", description = "Score of client information")
public class ClientScoreDto {

    @Schema(name = "clientId", description = "Identifier of client", example = "450")
    private Integer clientId;

    @Schema(name = "name", description = "Full name of client", example = "AUDELIA RAMIREZ RUIZ")
    private String name;
    
    @Schema(name = "score", description = "Score of client", example = "AA690")
    private String score;

    @Schema(name = "nationalIdentityNumber", description = "Number of DNI, code of CURP, etc. to identify a person in a country", example = "RALG911216MGTMPD02")
    private String nationalIdentityNumber;
}
