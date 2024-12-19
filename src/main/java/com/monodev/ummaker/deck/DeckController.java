package com.monodev.ummaker.deck;


import com.monodev.ummaker.deck.dto.DeckCreateRequest;
import com.monodev.ummaker.deck.dto.DeckDTO;
import com.monodev.ummaker.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    private final UserService userService;

    @GetMapping("api/decks/{id}")
    public DeckDTO findDeckById(@PathVariable("id") Long id) {
        return deckService.findDeckById(id);
    }

    @GetMapping("api/decks/new")
    public ResponseEntity<DeckDTO> createDeck(@AuthenticationPrincipal(errorOnInvalidType = true) DefaultOAuth2User userDetails) {
        return ResponseEntity.status(HttpStatus.OK).body(
                deckService.createDeck(new DeckCreateRequest(LocalDate.now(), LocalDate.now(), userService.getContext(userDetails)))
        );
    }

    @GetMapping("api/decks/{id}/reaction")
    public ResponseEntity<DeckDTO> toggleReaction(@PathVariable("id") Long id, @AuthenticationPrincipal(errorOnInvalidType = true) DefaultOAuth2User userDetails) {
        return ResponseEntity.ok(deckService.toggleReactionToDeck(id, userService.getContext(userDetails)));
    }
}
