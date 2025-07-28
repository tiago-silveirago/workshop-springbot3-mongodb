package com.tiago_silveirago.workshop_mongodb.services.exeptions;

public class DocumentInUseException extends RuntimeException {
    public DocumentInUseException(String message) {
        super(message);
    }
}
