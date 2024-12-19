package com.monodev.ummaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UnmatchedCardMakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnmatchedCardMakerApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome on home page";
    }

}
