package com.example.demo.dao;

import com.example.demo.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ITeacherDao extends JpaRepository<Teacher, Long> {
    public Teacher findByEmail(String email);
    public Teacher findByEmailAndPassword(String email, String password);
    public Optional<Teacher> findById(Long id);
    @Query("select t from Teacher t where t.id=?1")
    public Teacher findByIdSQL(Long id);
}
