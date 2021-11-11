package com.example.demo.controller.impl;

import com.example.demo.controller.CourseController;
import com.example.demo.model.dto.CourseDTO;
import com.example.demo.model.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CourseControllerImpl implements CourseController {

    private CourseService courseService;

    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ResponseEntity<List<CourseDTO>> findAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> saveCourse(Course course) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> updateCourse(Course course) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCourse(Long id) throws Exception {
        return null;
    }
}
