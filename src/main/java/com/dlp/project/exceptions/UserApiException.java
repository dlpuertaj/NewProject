package com.dlp.project.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserApiException extends RuntimeException{

    private final String exceptionMessage;

    UserApiException(String exceptionMessage){
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }
}
