package com.monodev.ummaker;


import com.monodev.ummaker.deck.exception.DeckNotFoundException;
import com.monodev.ummaker.user.exception.UserAlreadyExistsException;
import com.monodev.ummaker.user.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleUserNotFoundException(final UserNotFoundException exception) {
        return new ErrorResponse("USER_NOT_FOUND", exception.getMessage());
    }

    @ExceptionHandler(DeckNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleDeckNotFoundException(final DeckNotFoundException exception) {
        log.error("Deck with specified id could not be found");
        return new ErrorResponse("DECK_NOT_FOUND", "Deck not found.");
    }

    @ExceptionHandler(OAuth2AuthenticationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleOAuth2AuthenticationException(final OAuth2AuthenticationException exception) {
        return new ErrorResponse("OAUTH2_ERROR", "OAuth2 authentication failed.");
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleUserAlreadyExistsException(final UserAlreadyExistsException exception) {

        return new ErrorResponse("USER_ALREADY_EXISTS", String.format("User with username \"%s \" already exists.", exception.getMessage()));
    }

    public record ErrorResponse(String code, String message) {
    }

}
