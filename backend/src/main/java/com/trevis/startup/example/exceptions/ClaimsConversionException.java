package com.trevis.startup.example.exceptions;

import org.springframework.core.convert.ConversionException;

public class ClaimsConversionException extends ConversionException {
    public ClaimsConversionException(String explanation) {
        super(explanation);
    }
}
