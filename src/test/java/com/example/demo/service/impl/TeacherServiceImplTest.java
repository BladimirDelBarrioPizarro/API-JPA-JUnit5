package com.example.demo.service.impl;

import com.example.demo.dao.ITeacherDao;
import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.impl.dummy.TeacherDummy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@Tag("teacherService")
@Nested
@DisplayName("Example test Teacher Service Implementation")
@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    private ITeacherService teacherService;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        log.info("Running: {} with Method: {} with Tag {}",testInfo.getDisplayName(),testInfo.getTestMethod().get().getName(),testInfo.getTags());
        this.teacherService = mock(ITeacherService.class);
    }


    @Test
    void findAll() throws Exception {
        List<TeacherDTO> teacherDTOList = TeacherDummy.teacherDTOListDummy();
        when(teacherService.findAll()).thenReturn(teacherDTOList);
        List<TeacherDTO> teacherDTOS = teacherService.findAll();
        log.info(teacherDTOS.toString());
        assertNotNull(teacherDTOS);
        assertEquals(1,teacherDTOS.size());
        assertEquals(1L,teacherDTOS.get(0).getId());
        assertEquals("email@talento.com",teacherDTOS.get(0).getEmail());
        assert (teacherDTOS.size() > 0);
    }

    @Test
    void findById() {
    }

    @Test
    void saveTeacher() {
    }

    @Test
    void updateTeacher() {
    }

    @Test
    void deleteTeacher() {
    }

    @Test
    void findByIdSQL() {
    }
}