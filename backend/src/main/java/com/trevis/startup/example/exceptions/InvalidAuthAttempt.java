package com.trevis.startup.example.exceptions;

public class InvalidAuthAttempt extends Exception {
    public InvalidAuthAttempt(String explanation) {
        super(explanation);
    }
}
