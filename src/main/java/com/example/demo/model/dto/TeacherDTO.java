package com.example.demo.model.dto;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Language;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class TeacherDTO {
    private Long id;
    private String name;
    private String email;
    private String photo;
    private Date created_at;
    private List<Course> courses;
    private List<Language> languages;
}
