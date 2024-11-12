package com.monodev.ummaker.deck;

import com.monodev.ummaker.deck.exception.DeckNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeckService {
    private final DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public DeckDTO findDeckById(@PathVariable("id") Long id) {
        if (isDeckPresent(id)) {
            throw new DeckNotFoundException();
        }
        return DeckDTO.toDto(deckRepository.findById(id).get());
    }

    private boolean isDeckPresent(Long id) {
        return deckRepository.findById(id).isPresent();
    }
}
