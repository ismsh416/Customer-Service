package com.ijsolutions.Customer_Service.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException)
    ResponseEntity<Map> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        Map<String, Object> errorBody = [
                timestamp: new Date(),
                status   : HttpStatus.NOT_FOUND.value(),
                error    : ex.message,
                message  : ex.message,
                path     : request.requestURI
        ]
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception)
    ResponseEntity<Map> handleGenericException(Exception ex, HttpServletRequest request) {
        Map<String, Object> errorBody = [
                timestamp: new Date(),
                status   : HttpStatus.BAD_REQUEST.value(),
                error    : "Bad Request",
                message  : ex.message,
                path     : request.requestURI
        ]
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST)
    }
}
