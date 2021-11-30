package com.example.demo.service.impl;


import com.example.demo.dao.ITeacherDao;
import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;
import com.example.demo.model.mapper.TeacherMapper;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.impl.dummy.TeacherDummy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@Slf4j
@Tag("teacherService")
@Nested
@DisplayName("Example test Teacher Service Implementation")
@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @Mock
    private ITeacherDao teacherDao;

    @InjectMocks
    private TeacherServiceImpl teacherServiceImpl;

    private ITeacherService teacherService;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        MockitoAnnotations.openMocks(this); // Forma de instanciar la implementación con anotaciones @Mock @InjectMocks
        log.info("Running: {} with Method: {} with Tag {}",testInfo.getDisplayName(),testInfo.getTestMethod().get().getName(),testInfo.getTags());
        this.teacherService = mock(ITeacherService.class); // Forma de instanciar la interfaz.
    }


    @Test
    void findAll() throws Exception {
        // Given
        List<TeacherDTO> teacherDTOList = TeacherDummy.teacherDTOListDummy();
        when(teacherService.findAll()).thenReturn(teacherDTOList);
        // When
        List<TeacherDTO> teacherDTOS = teacherService.findAll();
        // Then
        assertNotNull(teacherDTOS);
        assertEquals(1,teacherDTOS.size());
        assertEquals(1L,teacherDTOS.get(0).getId());
        assertEquals("email@talento.com",teacherDTOS.get(0).getEmail());
        verify(teacherService).findAll();
        assert (teacherDTOS.size() > 0);
    }

    @Test
    void findById() throws Exception {
        // Given
        TeacherDTO teacherDTO = TeacherDummy.teacherDTODummy();
        when(teacherService.findById(anyLong())).thenReturn(teacherDTO);
        // When
        TeacherDTO teacherDTOResponse = teacherService.findById(1L);
        // Then
        assertEquals("email@talento.com",teacherDTOResponse.getEmail());
        assertEquals(1L,teacherDTOResponse.getId());
        assertTrue(teacherDTOResponse.getName().contains("name"));
        verify(teacherService).findById(anyLong());
    }

    @Test
    void saveTeacher() throws Exception {
        // Given

        // when(teacherService.saveTeacher(any(Teacher.class))).thenReturn(TeacherDummy.teacherDTODummy());
        when(teacherService.saveTeacher(any(Teacher.class))).then(new Answer<TeacherDTO>(){

            Long secuency = 1L;
            @Override
            public TeacherDTO answer(InvocationOnMock invocationOnMock) throws Throwable {
                Teacher teacher = invocationOnMock.getArgument(0);
                log.info(teacher.toString());
                teacher.setId(secuency);
                return TeacherMapper.mapTeacherToTeacherDTO(teacher);
            }
        });
        // When
        TeacherDTO teacherDTO = teacherService.saveTeacher(TeacherDummy.teacherDummy());
        // Then
        assertNotNull(teacherDTO.getId());
        assertEquals(1L,teacherDTO.getId());
        assertEquals("http://test",teacherDTO.getPhoto());
        verify(teacherService).saveTeacher(any(Teacher.class));
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