package com.example.demo.controller.impl;

import com.example.demo.controller.LanguageController;
import com.example.demo.service.LanguageService;

public class LanguageControllerImpl implements LanguageController {

    private LanguageService languageService;

    public LanguageControllerImpl(LanguageService languageService) {
     this.languageService = languageService;
    }
}
