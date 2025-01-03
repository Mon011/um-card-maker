package com.monodev.ummaker.user.auth.oauth2;

import com.monodev.ummaker.user.auth.usecase.LoadOAuthUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    private LoadOAuthUserUseCase loadOAuthUserUseCase;

    @Autowired
    public OAuth2UserService(LoadOAuthUserUseCase loadOAuthUserUseCase) {
        this.loadOAuthUserUseCase = loadOAuthUserUseCase;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("Loading user {}", userRequest.getClientRegistration().getRegistrationId());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        return loadOAuthUserUseCase.execute(oAuth2User);
    }

}
