package com.monodev.ummaker;


import com.monodev.ummaker.deck.DeckNotFoundException;
import com.monodev.ummaker.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
        return new ErrorResponse("USER_NOT_FOUND", "User not found.");
    }

    @ExceptionHandler(DeckNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleDeckNotFoundException(final DeckNotFoundException exception) {
        log.error("Deck with specified id could not be found");
        return new ErrorResponse("DECK_NOT_FOUND", "Deck not found.");
    }

    public record ErrorResponse(String code, String message) {
    }

}
