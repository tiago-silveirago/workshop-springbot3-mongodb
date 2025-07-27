package com.tiago_silveirago.workshop_mongodb.services.exeptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
