package com.monodev.ummaker.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public Set<String> getAllTagsName() {
        return tagRepository.findAll().stream().map(Tag::getName).collect(Collectors.toSet());
    }

}
