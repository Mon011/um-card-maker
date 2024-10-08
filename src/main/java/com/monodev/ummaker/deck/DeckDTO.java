package com.monodev.ummaker.deck;

import com.monodev.ummaker.user.User;

import java.time.LocalDate;

public record DeckDTO(User user, String name, String content, LocalDate createdAt, LocalDate updatedAt) {
}
