package com.monodev.ummaker.deck;

public class DeckNotFoundException extends RuntimeException {

    public DeckNotFoundException() {
    }

    public DeckNotFoundException(String message) {
        super(message);
    }
}
