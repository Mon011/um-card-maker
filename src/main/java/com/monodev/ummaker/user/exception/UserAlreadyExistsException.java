package com.monodev.ummaker.user.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public static UserAlreadyExistsException withUsername(String username) {
        return new UserAlreadyExistsException(String.format("User with username \"%s\" already exists.", username));
    }
}
