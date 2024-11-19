package com.monodev.ummaker.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<String> getAllTagsName() {
        var name = new ArrayList<String>();
        tagRepository.findAll().forEach(e -> name.add(e.getName()));
        return name;
    }


}
