package ua.alvin.springdemo.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.alvin.springdemo.entity.CustomerErrorResponse;
import ua.alvin.springdemo.exception.CustomerNotFoundException;

@ControllerAdvice
public class RestControllerAdvice {
    private CustomerErrorResponse customerErrorResponse;

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> exceptionHandler(Exception exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        customerErrorResponse = new CustomerErrorResponse(
                httpStatus.value(),
                exception.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(customerErrorResponse, httpStatus);
    }
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> exceptionHandler(CustomerNotFoundException notFoundException) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        customerErrorResponse = new CustomerErrorResponse(
                httpStatus.value(),
                notFoundException.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(customerErrorResponse, httpStatus);
    }
}
