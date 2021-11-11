package com.example.demo.service;

import com.example.demo.model.dto.CourseDTO;
import com.example.demo.model.entity.Course;


import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll() throws Exception;
    CourseDTO findById(Long id) throws Exception;
    CourseDTO saveCourse(Course course) throws Exception;
    CourseDTO updateCourse(Course course) throws Exception;
    void deleteCourse(Long id) throws Exception;
    Course findByIdSQL(Long id) throws Exception;
}

