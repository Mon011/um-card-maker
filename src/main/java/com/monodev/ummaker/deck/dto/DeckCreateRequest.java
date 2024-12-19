package com.monodev.ummaker.deck.dto;


import com.monodev.ummaker.deck.Deck;
import com.monodev.ummaker.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class DeckCreateRequest {

    @NotNull
    LocalDate createdAt;

    @NotNull
    LocalDate updatedAt;

    @NotNull
    User user;

    public static Deck toDomain(DeckCreateRequest deckCreateRequest) {
        return new Deck()
                .setUser(deckCreateRequest.getUser())
                .setCreatedAt(deckCreateRequest.getCreatedAt())
                .setUpdatedAt(deckCreateRequest.getUpdatedAt());
    }

}
