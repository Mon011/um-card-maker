package com.monodev.ummaker.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public Set<String> getAllTagsName() {
        var name = new HashSet<String>();
        tagRepository.findAll().forEach(e -> name.add(e.getName()));
        return name;
    }


}
