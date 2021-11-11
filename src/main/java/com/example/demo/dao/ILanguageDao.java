package com.example.demo.dao;

import com.example.demo.model.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ILanguageDao extends JpaRepository<Language,Long> {

   @Query("select l from Language l where l.id=?1")
    public Language findByIdSQL(Long id);

}
