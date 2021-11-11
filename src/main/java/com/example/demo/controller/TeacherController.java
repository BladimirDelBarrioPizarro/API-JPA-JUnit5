package com.example.demo.controller;

import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public interface TeacherController {

    @GetMapping(path = "/teachers",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<TeacherDTO>> findAll() throws Exception;

    @PostMapping(path = "/teachers",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<TeacherDTO> saveTeacher(@RequestBody Teacher teacher) throws Exception;

    @PutMapping(path = "/teachers",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<TeacherDTO> updateTeacher(@RequestBody Teacher teacher) throws Exception;

    @DeleteMapping( path = "/teachers/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Void> deleteTeacher(@PathVariable("id") Long id) throws Exception;
}
