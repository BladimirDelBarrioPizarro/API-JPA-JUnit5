package com.example.demo.controller.impl;

import com.example.demo.controller.TeacherController;
import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;
import com.example.demo.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class TeacherControllerImpl implements TeacherController {

    private ITeacherService teacherService;

    public TeacherControllerImpl(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public ResponseEntity<List<TeacherDTO>> findAll() throws Exception {
        log.info(" -- GET /teachers");
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TeacherDTO> saveTeacher(Teacher teacher) throws Exception {
        log.info(" -- POST /teachers {}",teacher.getName());
        return new ResponseEntity<>(teacherService.saveTeacher(teacher),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TeacherDTO> updateTeacher(Teacher teacher) throws Exception {
        log.info(" -- PUT /teachers {}",teacher.getName());
        return new ResponseEntity<>(teacherService.updateTeacher(teacher),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteTeacher(Long id) throws Exception {
        log.info(" -- DELETE /teachers {}",id);
        Teacher teacherRequest = teacherService.findByIdSQL(id);
        if(teacherRequest==null){
            return ResponseEntity.noContent().build();
        }
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
