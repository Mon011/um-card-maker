package com.monodev.ummaker.user.auth.oauth2;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OAuth2UserController {

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        return ResponseEntity.ok().body("Logout action performed successfully");
    }
}
