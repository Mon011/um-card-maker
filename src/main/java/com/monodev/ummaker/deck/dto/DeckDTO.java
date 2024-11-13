package com.monodev.ummaker.deck.dto;

import com.monodev.ummaker.deck.Deck;
import com.monodev.ummaker.user.User;
import com.monodev.ummaker.user.dto.UserDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DeckDTO(UserDTO user, @NotNull String name, String description, @NotNull String content,
                      @NotNull LocalDate createdAt, @NotNull LocalDate updatedAt) {
    public static DeckDTO toDto(Deck deck) {
        return new DeckDTO(UserDTO.toDto(deck.getUser()), deck.getName(), deck.getDescription(), deck.getContent(),
                deck.getCreatedAt(), deck.getUpdatedAt());
    }
}
