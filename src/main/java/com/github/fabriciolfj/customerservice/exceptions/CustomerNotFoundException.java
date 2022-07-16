package com.github.fabriciolfj.customerservice.exceptions;

public class CustomerNotFoundException extends InfrastructureException {

    public CustomerNotFoundException() {
        super(Errors.NOT_FOUND.getMessage());
    }
}
