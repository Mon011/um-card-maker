package com.monodev.ummaker.user;

import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String username, String email) {
    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUsername(), user.getEmail());
    }
}
