package com.example.test.hibernatevalidator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(ValidationException validException) {
        if(validException instanceof ConstraintViolationException){
            ConstraintViolationException exs = (ConstraintViolationException) validException;

            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                System.out.println("=======参数不合法=======:" + item.getMessage());
            }
        } /*else if (validException instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) validException).getBindingResult();
            if (bindingResult.hasErrors()) {
                for (ObjectError globalError : bindingResult.getAllErrors()) {
                    System.out.println(globalError.getDefaultMessage());
                }
            }
        } else if (validException instanceof BindException) {
            Errors errors = ((BindException) validException).getBindingResult();
            if (errors.hasErrors()) {
                for (ObjectError globalError : errors.getAllErrors()) {
                    System.out.println(globalError.getDefaultMessage());
                }
            }
        }*/

        return "bad request, " ;
    }
}