package com.gs.studentservice.exception;

import com.gs.studentservice.utils.StudentResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){

        List<FieldError> fieldErrors = ex.getFieldErrors();
        StudentResponse studentResponse= new StudentResponse();

        List<String> error= new ArrayList<>();
        for (FieldError e: fieldErrors){
            error.add(e.getDefaultMessage());
        }
        studentResponse.setError(error);
        studentResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentResponse.setMessage("Request Errors");

        return ResponseEntity.badRequest().body(studentResponse);
    }

    @ExceptionHandler({StudentNotFoundException.class,StudentIdNotNull.class})
    ResponseEntity<?> handleStudentNotFound(Exception ex){
        StudentResponse studentResponse= new StudentResponse();

        studentResponse.setError(ex.getMessage());
        studentResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentResponse.setMessage("Request Errors");
        return ResponseEntity.badRequest().body(studentResponse);
    }
}
