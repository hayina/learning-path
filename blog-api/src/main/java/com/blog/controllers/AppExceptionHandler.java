package com.blog.controllers;


import com.blog.models.ValidationExceptionDto;
import com.blog.models.AppExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ValidationExceptionDto illegalArgumentException(MethodArgumentNotValidException e){


        return new ValidationExceptionDto(HttpStatus.BAD_REQUEST.value(),
                e.getBindingResult().getFieldErrors()
                        .stream().map(error -> new ValidationExceptionDto.Error(error.getField(), error.getDefaultMessage()))
                        .collect(Collectors.toList())
        );

    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ EntityNotFoundException.class })
    public AppExceptionDto entityNotFoundException(EntityNotFoundException e) {

        return new AppExceptionDto(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
