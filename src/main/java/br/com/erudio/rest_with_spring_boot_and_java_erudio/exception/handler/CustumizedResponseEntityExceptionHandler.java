package br.com.erudio.rest_with_spring_boot_and_java_erudio.exception.handler;

import br.com.erudio.rest_with_spring_boot_and_java_erudio.exception.ExceptionResponde;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.exception.ResourceNotFoundException;
import br.com.erudio.rest_with_spring_boot_and_java_erudio.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustumizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponde> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponde, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponde> handleMathException(Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponde, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponde> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponde, HttpStatus.NOT_FOUND);
    }
}