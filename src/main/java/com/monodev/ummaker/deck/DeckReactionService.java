package com.monodev.ummaker.deck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeckReactionService {

    private final DeckReactionRepository deckReactionRepository;

    private final DeckService deckService;

    @Autowired
    public DeckReactionService(DeckReactionRepository deckReactionRepository, DeckService deckService) {
        this.deckReactionRepository = deckReactionRepository;
        this.deckService = deckService;
    }

    @GetMapping("/decks/{id}/reactions")
    public Long getNumberOfReactionByDeckId(@PathVariable("id") Long id) {
        deckService.findDeckById(id);
    }


}
