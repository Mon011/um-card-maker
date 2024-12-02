package com.monodev.ummaker.deck;

import com.monodev.ummaker.deck.dto.DeckCreateRequest;
import com.monodev.ummaker.deck.dto.DeckDTO;
import com.monodev.ummaker.deck.exception.DeckNotFoundException;
import com.monodev.ummaker.user.User;
import com.monodev.ummaker.user.UserDetailsModel;
import com.monodev.ummaker.user.UserService;
import com.monodev.ummaker.user.exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class DeckService {

    private final DeckRepository deckRepository;
    private final UserService userService;

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
    public DeckDTO toggleReactionToDeck(Long id, UserDetailsModel userDetailsModel) {
        Deck deck = deckRepository.findById(id).orElseThrow(DeckNotFoundException::new);
        User user = userService.findUserByUsername(userDetailsModel.getUsername()).orElseThrow(UserNotFoundException::new);

        var copy = deck.getDeckReactions();
        if (deck.getDeckReactions().contains(user)) {
            copy.remove(user);
        } else {
            copy.add(user);
        }

        deck.setDeckReactions(copy);

        return DeckDTO.toDto(deckRepository.save(deck));
    }
}
