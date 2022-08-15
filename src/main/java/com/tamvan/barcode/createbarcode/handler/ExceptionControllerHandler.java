package com.tamvan.barcode.createbarcode.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice(basePackages = {"com.tamvan.barcode.createbarcode.controllers"})
public class ExceptionControllerHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpEntity<String> internalServerError(Exception ex) {
        log.error("Error generate barcode.", ex);
        return new ResponseEntity<>("Error when generate barcode : " + ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
