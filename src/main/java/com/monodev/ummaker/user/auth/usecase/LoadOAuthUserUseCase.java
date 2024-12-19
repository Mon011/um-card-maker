package com.monodev.ummaker.user.auth.usecase;


import com.monodev.ummaker.user.UserService;
import com.monodev.ummaker.user.dto.UserDTO;
import com.monodev.ummaker.user.dto.request.SaveUserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class LoadOAuthUserUseCase {

    private final UserService userService;

    public OAuth2User execute(OAuth2User oAuth2User) {
        return processOAuth2User(oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2User oAuth2User) {
        UserDTO userDTO = new UserDTO(
                Objects.requireNonNull(oAuth2User.getAttribute("login")).toString(),
                Objects.requireNonNull(oAuth2User.getAttribute("avatar_url")).toString()
        );

        log.info("Processing authorized user");

        if (userService.findUserByUsername(userDTO.username()).isPresent()) {
            log.info("User already exist");
            return oAuth2User;
        }

        userService.saveUser(new SaveUserRequest(userDTO.username(), userDTO.picture()));

        return oAuth2User;
    }

}
