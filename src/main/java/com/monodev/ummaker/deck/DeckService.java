package com.monodev.ummaker.deck;

import com.monodev.ummaker.deck.dto.DeckCreateRequest;
import com.monodev.ummaker.deck.dto.DeckDTO;
import com.monodev.ummaker.deck.exception.DeckNotFoundException;
import com.monodev.ummaker.user.User;
import com.monodev.ummaker.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
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

    public Deck findDeckById(@PathVariable("id") Long id) {
        return deckRepository.findById(id)
                .orElseThrow(DeckNotFoundException::new);
    }

    @PreAuthorize("#d.user.username == authentication.principal.username")
    @Transactional
    public DeckDTO toggleReactionToDeck(@P("d") Deck deck, User user) {
        user.addReaction(deck);
        userRepository.save(user);
        return DeckDTO.toDto(deck);
    }
}
