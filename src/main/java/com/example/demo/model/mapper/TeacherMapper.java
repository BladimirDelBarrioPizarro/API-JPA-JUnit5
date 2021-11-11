package com.example.demo.model.mapper;

import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeacherMapper {
    public static List<TeacherDTO> mapTeacherListToTeacherDTO(List<Teacher> teacherList) {
        return teacherList.stream().map(TeacherMapper::mapTeacherToTeacherDTO).collect(Collectors.toList());
    }

    public static TeacherDTO mapTeacherToTeacherDTO(Teacher teacher){
        return TeacherDTO.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .email(teacher.getEmail())
                .photo(teacher.getPhoto())
                .created_at(teacher.getCreated_at())
                .courses(teacher.getCourses())
                .languages(teacher.getLanguageList())
                .build();
    }

    public static TeacherDTO mapTeacherOptionalToTeacherDTO(Optional<Teacher> teacher) {
        return TeacherDTO.builder()
                .id(teacher.get().getId())
                .name(teacher.get().getName())
                .email(teacher.get().getEmail())
                .photo(teacher.get().getPhoto())
                .created_at(teacher.get().getCreated_at())
                .courses(teacher.get().getCourses())
                .languages(teacher.get().getLanguageList())
                .build();
    }
}
