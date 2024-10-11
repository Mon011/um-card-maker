package com.monodev.ummaker.deck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DeckService {
    private final DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @GetMapping("/decks/{id}")
    public DeckDTO findDeckById(@PathVariable("id") Long id) {
        if(isDeckPresent(id)) {
            throw new DeckNotFoundException();
        }
        return DeckDTO.toDto(deckRepository.findById(id).get());
    }

    public boolean isDeckPresent(Long id) {
        return deckRepository.findById(id).isPresent();
    }
}
