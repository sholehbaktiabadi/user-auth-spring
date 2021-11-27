package com.example.userService.exception;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(ApiRequestException message){
        super(message);
    }

    public ApiRequestException(String message){
        super(message);
    }
}
