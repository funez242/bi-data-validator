package com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeParseException;

/**
 * The class Error manager.
 */
@Component
@Slf4j
public class ErrorManager {
	
	private long totalErrors = 0;

    /**
     * Gets total errors.
     *
     * @return the total errors
     */
    public long getTotalErrors() {
		return totalErrors;
	}

    /**
     * Gets http status for exception.
     *
     * @param e the e
     * @return the http status for exception
     */
    public HttpStatus getHttpStatusForException(Exception e) {

		logError(e);

		if (e instanceof BadRequestException || e instanceof DateTimeParseException || e instanceof IllegalArgumentException) {
			return HttpStatus.BAD_REQUEST;
		}
		
		if(e instanceof ObjectNotFoundException || e instanceof NotFoundException) {
			return HttpStatus.NOT_FOUND;
		}
		
		if(e instanceof ResourceAlreadyExistsException) {
			return HttpStatus.CONFLICT;
		}

		return HttpStatus.INTERNAL_SERVER_ERROR;

	}

    /**
     * Log error.
     *
     * @param e the e
     */
    public void logError(Exception e) {
		totalErrors++;
		log.error(e.getMessage(), e);
	}

    /**
     * Log error.
     *
     * @param e       the e
     * @param message the message
     */
    public void logError(Exception e, String message) {
		totalErrors++;
		log.error(message, e);
	}

}