package com.example.demo.service.impl;

import com.example.demo.dao.ITeacherDao;
import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;
import com.example.demo.model.mapper.TeacherMapper;
import com.example.demo.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeacherServiceImpl implements ITeacherService {

    private ITeacherDao teacherDao;

    public TeacherServiceImpl(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<TeacherDTO> findAll() throws Exception {
        try{
            return TeacherMapper.mapTeacherListToTeacherDTO(teacherDao.findAll());
        }catch (Exception ex){
            log.error(" -- ERROR GET /teacher/{}", ex.getMessage());
            throw new Exception(ex);
        }
    }

   @Override
    public TeacherDTO findById(Long id) throws Exception {
        try{
            return TeacherMapper.mapTeacherOptionalToTeacherDTO(teacherDao.findById(id));
        }catch (Exception ex){
            log.error(" -- ERROR GET /teacher/{}", ex.getMessage());
            throw new Exception(ex);
        }
    }

    @Override
    public TeacherDTO saveTeacher(Teacher teacher) throws Exception {
        try{
            if (teacherDao.findByEmail(teacher.getEmail()) == null) {
                return TeacherMapper.mapTeacherToTeacherDTO(teacherDao.save(teacher));
            }
            else{
                throw new Exception("El email existe");
            }

        }catch (Exception ex){
            log.error(" -- ERROR POST /teacher/{}", ex.getMessage());
            throw new Exception(ex);
        }
    }

    @Override
    public TeacherDTO updateTeacher(Teacher teacher) throws Exception {
        try{
            Optional<Teacher> t = teacherDao.findById(teacher.getId());
            if (t.isEmpty()) {
                throw new Exception("Teacher not found -> No exits");
            }
            else {
                teacher.setCreated_at(t.get().getCreated_at());
                return TeacherMapper.mapTeacherToTeacherDTO(teacherDao.save(teacher));
            }

        }catch (Exception ex){
            log.error(" -- ERROR PUT /teacher/{}", ex.getMessage());
            throw new Exception(ex);
        }
    }

    @Override
    public void deleteTeacher(Long id) throws Exception {
        try{
            teacherDao.deleteById(id);
        }catch (Exception ex){
            log.error(" -- ERROR DELETE /needs {}",ex.getMessage());
            throw new Exception(ex);
        }
    }

    @Override
    public Teacher findByIdSQL(Long id) throws Exception {
        try{
            return teacherDao.findByIdSQL(id);
        }catch (Exception ex){
            log.error(" -- ERROR GET /needs {}",ex.getMessage());
            throw new Exception(ex);
        }
    }
}
