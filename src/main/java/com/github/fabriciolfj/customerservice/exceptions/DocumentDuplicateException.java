package com.github.fabriciolfj.customerservice.exceptions;

public class DocumentDuplicateException extends InfrastructureException {

    public DocumentDuplicateException() {
        super(Errors.DOCUMENT_DUPLICATE.getMessage());
    }
}
