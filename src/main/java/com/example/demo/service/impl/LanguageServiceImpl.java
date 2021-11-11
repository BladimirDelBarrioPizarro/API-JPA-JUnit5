package com.example.demo.service.impl;

import com.example.demo.dao.ILanguageDao;
import com.example.demo.model.dto.LanguageDTO;
import com.example.demo.model.entity.Language;
import com.example.demo.model.mapper.LanguageMapper;
import com.example.demo.model.mapper.TeacherMapper;
import com.example.demo.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {

    private ILanguageDao languageDao;

    public LanguageServiceImpl(ILanguageDao languageDao){
        this.languageDao = languageDao;
    }

    @Override
    public List<LanguageDTO> findAll() throws Exception {
        try{
           return LanguageMapper.mapLanguageListToLanguageDTO(languageDao.findAll());
        }catch (Exception ex){
            log.error(" -- ERROR GET /languages/{}", ex.getMessage());
            throw new Exception(ex);
        }
    }

    @Override
    public LanguageDTO findById(Long id) throws Exception {
        return null;
    }

    @Override
    public LanguageDTO saveLanguage(Language language) throws Exception {
        try{
            return LanguageMapper.mapLanguageToLanguageDTO(languageDao.save(language));
        }catch (Exception ex){
            log.error(" -- ERROR POST /language/{}", ex.getMessage());
            throw new Exception(ex);
        }
    }

    @Override
    public LanguageDTO updateLanguage(Language language) throws Exception {
        return null;
    }

    @Override
    public void deleteLanguage(Long id) throws Exception {

    }

    @Override
    public Language findByIdSQL(Long id) throws Exception {
        return languageDao.findByIdSQL(id);
    }
}
