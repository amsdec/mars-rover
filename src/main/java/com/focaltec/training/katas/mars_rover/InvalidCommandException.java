package com.focaltec.training.katas.mars_rover;

public class InvalidCommandException extends RuntimeException {

    private static final long serialVersionUID = 7808366574940514186L;

    public InvalidCommandException(final String message) {
        super(message);
    }

}
