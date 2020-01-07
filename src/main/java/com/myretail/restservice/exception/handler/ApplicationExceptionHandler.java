package com.myretail.restservice.exception.handler;

import com.myretail.restservice.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final Map<String, String> handleResourceNotFoundException(ResourceNotFoundException exn) {

        log.debug("Handling Resource Not Found Exception");

        Map<String, String> map = new HashMap<>();
        map.put("Message", exn.getMessage());
        return map;
    }
}
