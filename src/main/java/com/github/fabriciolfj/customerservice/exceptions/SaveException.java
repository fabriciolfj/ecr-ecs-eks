package com.github.fabriciolfj.customerservice.exceptions;

public class SaveException extends InfrastructureException {

    public SaveException() {
        super(Errors.SAVE_ERROR.getMessage());
    }
}
