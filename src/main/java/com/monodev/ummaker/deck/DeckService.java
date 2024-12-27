package com.monodev.ummaker.deck;

import com.monodev.ummaker.deck.dto.DeckCreateRequest;
import com.monodev.ummaker.deck.dto.DeckDTO;
import com.monodev.ummaker.deck.exception.DeckNotFoundException;
import com.monodev.ummaker.user.User;
import com.monodev.ummaker.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class DeckService {

    private final DeckRepository deckRepository;

    private final UserRepository userRepository;

    public DeckDTO createDeck(DeckCreateRequest deckCreateRequest) {
        var deck = deckRepository.save(DeckCreateRequest.toDomain(deckCreateRequest));

        return DeckDTO.toDto(deck);
    }

    public DeckDTO findDeckById(@PathVariable("id") Long id) {
        return deckRepository.findById(id)
                .map(DeckDTO::toDto)
                .orElseThrow(DeckNotFoundException::new);
    }

    @Transactional
    public DeckDTO toggleReactionToDeck(Long id, User user) {
        Deck deck = deckRepository.findById(id).orElseThrow(DeckNotFoundException::new);

        user.addReaction(deck);
        userRepository.save(user);
        return DeckDTO.toDto(deck);
    }
}
