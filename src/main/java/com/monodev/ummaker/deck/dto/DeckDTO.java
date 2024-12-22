package com.monodev.ummaker.deck.dto;

import com.monodev.ummaker.deck.Deck;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DeckDTO(Long user, @NotNull String name, String description, @NotNull String content,
                      @NotNull LocalDate createdAt, @NotNull LocalDate updatedAt) {
    public static DeckDTO toDto(Deck deck) {
        return new DeckDTO(deck.getUser().getId(), deck.getName(), deck.getDescription(), deck.getContent(),
                deck.getCreatedAt(), deck.getUpdatedAt());
    }
}
