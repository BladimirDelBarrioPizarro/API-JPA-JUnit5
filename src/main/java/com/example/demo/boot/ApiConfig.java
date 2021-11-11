package com.example.demo.boot;

import com.example.demo.controller.CourseController;
import com.example.demo.controller.LanguageController;
import com.example.demo.controller.TeacherController;
import com.example.demo.controller.impl.CourseControllerImpl;
import com.example.demo.controller.impl.LanguageControllerImpl;
import com.example.demo.controller.impl.TeacherControllerImpl;
import com.example.demo.dao.ICoursesDao;
import com.example.demo.dao.ILanguageDao;
import com.example.demo.dao.ITeacherDao;
import com.example.demo.service.CourseService;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.LanguageService;
import com.example.demo.service.impl.CourseServiceImpl;
import com.example.demo.service.impl.LanguageServiceImpl;
import com.example.demo.service.impl.TeacherServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiConfig {

    @Bean
    public ITeacherService teacherService(ITeacherDao teacherDao){
        return new TeacherServiceImpl(teacherDao);
    }

    @Bean
    public TeacherController teacherController(ITeacherService teacherService) {
       return new TeacherControllerImpl(teacherService);
    }

    @Bean
    public CourseService courseService(ICoursesDao iCoursesDao) {
        return new CourseServiceImpl(iCoursesDao);
    }

    @Bean
    public CourseController courseController(CourseService courseService) {
        return new CourseControllerImpl(courseService);
    }

    @Bean
    public LanguageService languageService(ILanguageDao iLanguageDao) {
        return new LanguageServiceImpl(iLanguageDao);
    }

    @Bean
    public LanguageController languageController(LanguageService languageService){
        return new LanguageControllerImpl(languageService);
    }
}
