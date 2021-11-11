package com.example.demo.service.impl;

import com.example.demo.dao.ICoursesDao;
import com.example.demo.model.dto.CourseDTO;
import com.example.demo.model.entity.Course;
import com.example.demo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private ICoursesDao iCoursesDao;

    public CourseServiceImpl(ICoursesDao iCoursesDao) {
        this.iCoursesDao = iCoursesDao;
    }

    @Override
    public List<CourseDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public CourseDTO findById(Long id) throws Exception {
        return null;
    }

    @Override
    public CourseDTO saveCourse(Course course) throws Exception {
        return null;
    }

    @Override
    public CourseDTO updateCourse(Course course) throws Exception {
        return null;
    }

    @Override
    public void deleteCourse(Long id) throws Exception {

    }

    @Override
    public Course findByIdSQL(Long id) throws Exception {
        return null;
    }
}
