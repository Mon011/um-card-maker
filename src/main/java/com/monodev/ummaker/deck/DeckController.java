package com.monodev.ummaker.deck;


import com.monodev.ummaker.deck.dto.DeckCreateRequest;
import com.monodev.ummaker.deck.dto.DeckDTO;
import com.monodev.ummaker.user.UserDetailsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("api/decks/{id}")
    public DeckDTO findDeckById(@PathVariable("id") Long id) {
        return deckService.findDeckById(id);
    }

    @GetMapping("api/decks/new")
    public ResponseEntity<DeckDTO> createDeck(@AuthenticationPrincipal UserDetailsModel user) {
        var deckCreation = deckService.createDeck(new DeckCreateRequest(LocalDate.now(), LocalDate.now(), user));

        return ResponseEntity.ok(deckCreation);
    }

    @GetMapping("api/decks/{id}/reaction")
    public ResponseEntity<DeckDTO> toggleReaction(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetailsModel userDetailsModel) {
        return ResponseEntity.ok(deckService.toggleReactionToDeck(id, userDetailsModel));
    }
}
