package com.caua.deliveryrequest.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
