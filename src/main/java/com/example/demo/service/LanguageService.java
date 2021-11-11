package com.example.demo.service;

import com.example.demo.model.dto.LanguageDTO;
import com.example.demo.model.entity.Language;

import java.util.List;


public interface LanguageService {

    List<LanguageDTO> findAll() throws Exception;
    LanguageDTO findById(Long id) throws Exception;
    LanguageDTO saveLanguage(Language language) throws Exception;
    LanguageDTO updateLanguage(Language language) throws Exception;
    void deleteLanguage(Long id) throws Exception;
    Language findByIdSQL(Long id) throws Exception;
}
