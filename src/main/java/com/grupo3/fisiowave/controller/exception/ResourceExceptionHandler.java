package com.grupo3.fisiowave.controller.exception;

import com.grupo3.fisiowave.service.exception.BadCredentialException;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import com.grupo3.fisiowave.service.exception.ValidateException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(error)
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<StandardError> validateException(ValidateException e, HttpServletRequest request) {
        String error = "Requisição inválida";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(error)
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity<StandardError> badCredentials(BadCredentialException e, HttpServletRequest request) {
        String error = "Credenciais inválidas";
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError standardError = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(error)
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(standardError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String error = "Requisição inválida";
        String message = "Um ou mais campos estão inválidos. Preencha as informações corretas e tente novamente.";

        List<StandardError.Object> problemsObjects = ex.getBindingResult().getAllErrors().stream().map(err ->
                        StandardError.Object.builder()
                                .name(((FieldError) err).getField())
                                .userMessage(err.getDefaultMessage())
                                .build())
                .toList();

        StandardError standardError = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(error)
                .message(message)
                .path(request.getDescription(false).replace("uri=", ""))
                .objects(problemsObjects)
                .build();

        return ResponseEntity.status(status).body(standardError);
    }
}
