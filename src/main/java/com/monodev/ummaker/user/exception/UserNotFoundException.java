package com.monodev.ummaker.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException withId(Long id) {
        return new UserNotFoundException(String.format("User with id: %d not found.", id));
    }
}
