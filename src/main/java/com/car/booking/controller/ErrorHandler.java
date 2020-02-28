package com.car.booking.controller;


import com.car.booking.controller.dto.SystemMessageDto;
import com.car.booking.exception.DataAlreadyExistException;
import com.car.booking.exception.UnprocessedException;
import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<SystemMessageDto> notFoundError(Exception e) {
        log.error("Error: ", e);

        return new ResponseEntity<>(new SystemMessageDto(
                HttpStatus.NOT_FOUND,
                "not_found",
                e.getLocalizedMessage()
        ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class, DataIntegrityViolationException.class})
    public ResponseEntity<SystemMessageDto> illegalArgument(Exception e) {
        log.error("Error: ", e);

        return new ResponseEntity<>(new SystemMessageDto(
                HttpStatus.BAD_REQUEST,
                "invalid_input",
                e.getLocalizedMessage()
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity<SystemMessageDto> dataAlreadyExist(Exception e) {
        log.error("Data already exist error: ", e);

        return new ResponseEntity<>(new SystemMessageDto(
            HttpStatus.CONFLICT,
            "data_exists",
            e.getLocalizedMessage()
        ), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnprocessedException.class)
    public ResponseEntity<SystemMessageDto> unprocessed(Exception e) {
        log.error("Unprocessed error: ", e);

        return new ResponseEntity<>(new SystemMessageDto(
            HttpStatus.UNPROCESSABLE_ENTITY,
            "unprocessed_error",
            e.getLocalizedMessage()
        ), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SystemMessageDto> generalError(Exception e) {
        log.error("General error: ", e);

        return new ResponseEntity<>(new SystemMessageDto(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "internal_error",
            e.getLocalizedMessage()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
