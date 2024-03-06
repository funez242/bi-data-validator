package com.finvivir.process.bi.unit.provide;

import com.finvivir.process.bi.unit.provide.dto.PagePersonsResult;
import com.finvivir.process.bi.unit.provide.dto.ResponseStatusError;
import com.finvivir.process.bi.unit.provide.dto.ValidatedData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * The interface Process bi unit controller.
 * Description: Describes the endpoint´s description
 */
@Validated
public interface BiDataValidatorController {


    @Operation(summary = "Get business validated data", description = "Get lists with validated data, to get data validation result", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "BiDataValidation"
    })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Validated data retrieved correctly", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidatedData.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseStatusError.class))),
        @ApiResponse(responseCode = "500", description = "Internal error while retrieving persons", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseStatusError.class)))
    })
    @GetMapping(value = "/getDataValidation", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ValidatedData> getDataValidation(
            @Parameter(in = ParameterIn.HEADER, description = "Identifier of country to consult" +
                    "(Based in ISO 3166-1 alpha 3, more information in [this page](https://en.wikipedia" +
                    ".org/wiki/ISO_3166-1_alpha-3))" ,required=true,schema=@Schema()) @RequestHeader(value="X-Request-Country",
                    required=true) String countryCode,
            @Nullable @Parameter(in = ParameterIn.QUERY, description = "Retrieve results from an accurate date" ,required=false,schema=@Schema(type = "string",format = "date", pattern = "^\\d{4}-\\d{2}-\\d{2}$")) @Valid @RequestParam(value = "operationDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate operationDate);

}
