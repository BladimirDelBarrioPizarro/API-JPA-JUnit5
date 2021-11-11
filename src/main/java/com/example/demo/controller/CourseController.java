package com.example.demo.controller;

import com.example.demo.model.dto.CourseDTO;
import com.example.demo.model.entity.Course;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public interface CourseController {

    @GetMapping(path = "/courses",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<CourseDTO>> findAll() throws Exception;

    @PostMapping(path = "/courses",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<CourseDTO> saveCourse(@RequestBody Course course) throws Exception;

    @PutMapping(path = "/courses",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<CourseDTO> updateCourse(@RequestBody Course course) throws Exception;

    @DeleteMapping( path = "/courses/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id) throws Exception;
}
