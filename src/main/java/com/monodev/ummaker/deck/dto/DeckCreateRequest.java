package com.monodev.ummaker.deck.dto;


import com.monodev.ummaker.deck.Deck;
import com.monodev.ummaker.tag.Tag;
import com.monodev.ummaker.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class DeckCreateRequest {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String content;

    @NotNull
    LocalDate createdAt;

    @NotNull
    LocalDate updatedAt;

    @NotNull
    User user;

    Set<Tag> tags;

    public static Deck toDomain(DeckCreateRequest deckCreateRequest) {
        return new Deck()
                .setName(deckCreateRequest.getName())
                .setDescription(deckCreateRequest.getDescription())
                .setContent(deckCreateRequest.getContent())
                .setUser(deckCreateRequest.getUser())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setTags(deckCreateRequest.getTags());
    }

}
