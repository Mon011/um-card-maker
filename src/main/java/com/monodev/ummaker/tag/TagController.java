package com.monodev.ummaker.tag;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("api/tags")
    public Set<String> getAllTags() {
        return tagService.getAllTagsName();
    }
}
