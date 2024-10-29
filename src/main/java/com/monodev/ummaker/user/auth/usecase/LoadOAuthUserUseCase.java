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
                Objects.requireNonNull(oAuth2User.getAttribute("username")).toString(),
                Objects.requireNonNull(oAuth2User.getAttribute("picture")).toString()
        );

        userService.saveUser(new SaveUserRequest(userDTO.username(), userDTO.picture()));

        return oAuth2User;
    }

}
