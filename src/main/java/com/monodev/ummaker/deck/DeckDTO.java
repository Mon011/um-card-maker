package com.monodev.ummaker.deck;

import com.monodev.ummaker.user.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DeckDTO(User user, @NotNull String name, String description, @NotNull String content,
                      @NotNull LocalDate createdAt, @NotNull LocalDate updatedAt) {
    public static DeckDTO toDto(Deck deck) {
        return new DeckDTO(deck.getUser(), deck.getName(), deck.getDescription(), deck.getContent(),
                deck.getCreatedAt(), deck.getUpdatedAt());
    }
}
