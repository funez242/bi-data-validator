/** 
 * @autor Jose Funez
 * ControllerImp class that provide information respect to business rules
 */

package com.finvivir.process.bi.unit.provide;

import com.finvivir.process.bi.unit.business.DataValidatorService;

import com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement.ErrorManager;

import com.finvivir.process.bi.unit.provide.dto.ValidatedData;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;


/**
 * The class Process bi unit controller.
 * Description: Controller class: operations request handler
 *
 */
@RestController
@RequestMapping("/v1")
@Slf4j
public class BiDataValidatorControllerImpl implements BiDataValidatorController {

    private final DataValidatorService dataValidatorService;
    private final ErrorManager errorManager;

    /**
     * Instantiates a new Process bi unit controller.
     *
     * @param dataValidatorService the person service
     * @param errorManager  the error manager
     */
    @Autowired
    public BiDataValidatorControllerImpl(DataValidatorService dataValidatorService , ErrorManager errorManager) {
        this.dataValidatorService = dataValidatorService;
        this.errorManager = errorManager;
    }

    public ResponseEntity<ValidatedData> getDataValidation(
            String countryCode,
            LocalDate operationDate){
        try{
            return ResponseEntity.ok(this.dataValidatorService.getValidatedBusinessData(countryCode,
                                     operationDate));
        } catch (Exception e) { // if a throw appear, we return error response
            throw new ResponseStatusException(errorManager.getHttpStatusForException(e), e.getMessage(), e);
        }
    }

}
