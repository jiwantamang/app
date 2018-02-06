package com.mahuriventures.erp.desktop.exception;

import java.io.IOException;

public class SourceNotFoundException extends RuntimeException{
    public SourceNotFoundException(String message){
        super(message);
    }

    public SourceNotFoundException(Throwable throwable){
        super(throwable);
    }

    public SourceNotFoundException(String message,Throwable throwable){
        super(message,throwable);
    }
}
