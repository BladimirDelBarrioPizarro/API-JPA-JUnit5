package com.example.demo.service;

import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> findAll() throws Exception;
    TeacherDTO findById(Long id) throws Exception;
    TeacherDTO saveTeacher(Teacher child) throws Exception;
    TeacherDTO updateTeacher(Teacher child) throws Exception;
    void deleteTeacher(Long id) throws Exception;
    Teacher findByIdSQL(Long id) throws Exception;
}
