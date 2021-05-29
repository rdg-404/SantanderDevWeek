package com.project.bootcamp.exceptions;

import com.project.bootcamp.util.messageUtils;

public class notFoundException extends RuntimeException{
    public notFoundException(){
        super(messageUtils.NO_RECORDS_FOUND);
    }
}
