package com.monodev.ummaker.deck;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

}
