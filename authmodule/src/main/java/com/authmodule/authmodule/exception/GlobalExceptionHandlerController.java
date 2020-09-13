package com.authmodule.authmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse response, CustomException customException) throws IOException {
        response.sendError(customException.getHttpStatus().value(), customException.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }

}
