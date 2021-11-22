package com.example.demo.model.mapper;

import com.example.demo.model.dto.LanguageDTO;
import com.example.demo.model.entity.Language;

import java.util.List;
import java.util.stream.Collectors;

public class LanguageMapper {
    public static List<LanguageDTO> mapLanguageListToLanguageDTO(List<Language> languageList) {
        return languageList.stream().map(LanguageMapper::mapLanguageToLanguageDTO).collect(Collectors.toList());
    }

    public static LanguageDTO mapLanguageToLanguageDTO(Language language) {
        return LanguageDTO.builder()
                .id(language.getId())
                .name(language.getName())
                .created_at(language.getCreated_at())
                .build();
    }
}
