package com.monodev.ummaker.user.dto;

import com.monodev.ummaker.user.User;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String username, String picture) {
    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUsername(), user.getPicture());
    }
}
