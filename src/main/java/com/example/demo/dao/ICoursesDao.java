package com.example.demo.dao;


import com.example.demo.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoursesDao extends JpaRepository<Course, Long> {
}
