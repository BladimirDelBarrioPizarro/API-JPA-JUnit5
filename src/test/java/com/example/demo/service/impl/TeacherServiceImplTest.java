package com.example.demo.service.impl;


import com.example.demo.dao.ITeacherDao;
import com.example.demo.model.dto.TeacherDTO;
import com.example.demo.model.entity.Teacher;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.impl.dummy.TeacherDummy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
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
        List<TeacherDTO> teacherDTOList = TeacherDummy.teacherDTOListDummy();
        when(teacherService.findAll()).thenReturn(teacherDTOList);
        List<TeacherDTO> teacherDTOS = teacherService.findAll();
        assertNotNull(teacherDTOS);
        assertEquals(1,teacherDTOS.size());
        assertEquals(1L,teacherDTOS.get(0).getId());
        assertEquals("email@talento.com",teacherDTOS.get(0).getEmail());
        verify(teacherService).findAll();
        assert (teacherDTOS.size() > 0);
    }

    @Test
    void findById() throws Exception {
        TeacherDTO teacherDTO = TeacherDummy.teacherDTODummy();
        when(teacherService.findById(anyLong())).thenReturn(teacherDTO);
        TeacherDTO teacherDTOResponse = teacherService.findById(1L);
        assertEquals("email@talento.com",teacherDTOResponse.getEmail());
        assertEquals(1L,teacherDTOResponse.getId());
        assertTrue(teacherDTOResponse.getName().contains("name"));
        verify(teacherService).findById(anyLong());
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