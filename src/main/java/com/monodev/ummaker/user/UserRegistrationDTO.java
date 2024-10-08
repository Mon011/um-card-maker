package com.monodev.ummaker.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRegistrationDTO(@NotNull @Size(min = 4, max = 20) String username, @NotNull @Email String email,
                                  @Size(min = 4, max = 12) String password) {
}
