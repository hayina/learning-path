package com.blog.models;

import com.blog.models.AppExceptionDto;

import java.util.ArrayList;
import java.util.List;

public class ValidationExceptionDto {

    public int status;

    public List<Error> errors = new ArrayList<>();

    public ValidationExceptionDto(int status, List<Error> errors) {
        this.status = status;
        this.errors = errors;
    }

    public static class Error {
        public String field;
        public String message;

        public Error(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
