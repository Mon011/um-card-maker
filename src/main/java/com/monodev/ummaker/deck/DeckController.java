package com.monodev.ummaker.deck;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/decks/{id}")
    public DeckDTO findDeckById(@PathVariable("id") Long id) {
        return deckService.findDeckById(id);
    }
}
