package com.github.fabriciolfj.customerservice.exceptions;

import java.util.ResourceBundle;

public enum Errors {

    NOT_FOUND,
    SAVE_ERROR,
    DOCUMENT_DUPLICATE;


    public String getMessage() {
        var bundle = ResourceBundle.getBundle("messages/exceptions");
        return bundle.getString(this.name() + ".message");
    }
}
