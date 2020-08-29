package com.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class AppExceptionDto {

    public int status;
    public String message;

    @JsonIgnore
    public int code;


    public AppExceptionDto(int status, String message) {
        this.status = status;
        this.message = message;
    }


}
