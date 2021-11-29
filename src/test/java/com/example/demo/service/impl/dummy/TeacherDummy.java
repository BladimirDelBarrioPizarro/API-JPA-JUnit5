package com.example.demo.service.impl.dummy;

import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TeacherDummy {

    public static List<TeacherDTO> teacherDTOListDummy(){
        return Collections.singletonList(teacherDTODummy());
    }

    public static TeacherDTO teacherDTODummy() {
        return  TeacherDTO.builder()
                .id(1L)
                .languages(new ArrayList<>())
                .courses(new ArrayList<>())
                .created_at(new Date())
                .photo("http://test")
                .email("email@talento.com")
                .name("name")
                .build();
    }

    public static Teacher teacherDummy(){
        Date date = new Date();
        return Teacher.builder()
                .id(1L)
                .courses(new ArrayList<>())
                .created_at(new Timestamp(date.getTime()))
                .languageList(new ArrayList<>())
                .password("xxxxxx")
                .photo("http://test")
                .email("email@talento.com")
                .name("name")
                .build();
    }
}
