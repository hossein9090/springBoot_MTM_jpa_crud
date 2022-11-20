package com.hossein.springboot_coursestudenttrain.service;


import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import com.hossein.springboot_coursestudenttrain.exception.EntityNotFoundExceptionById;
import com.hossein.springboot_coursestudenttrain.exception.IdNullException;
import com.hossein.springboot_coursestudenttrain.repo.StudentRepo;
import com.hossein.springboot_coursestudenttrain.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.Mockito.doNothing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class StudentServiceImplTest {

    private static final Long ID = 12L;
    private static final String NAME = "Hesam";

    private Optional<StudentEntity> instance() {
        StudentEntity student = new StudentEntity();
        student.setId(ID);
        student.setName(NAME);
        return Optional.of(student);
    }

    private StudentEntity instance2() {
        StudentEntity student = new StudentEntity();
        student.setId(ID);
        student.setName(NAME);
        CourseEntity course = new CourseEntity();
        course.setId(1L);
        course.setName("java");
        Set courseSet = new HashSet();
        courseSet.add(course);
        student.setCourses(courseSet);
        return student;
    }

    StudentEntity studentEntity;

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Autowired
    private TestEntityManager testEntityManager;
//
//    @BeforeAll
//    public void setup(){
//        this.studentEntity = new StudentEntity();
//        this.studentEntity.setName("asal");
//        testEntityManager.persist(this.studentEntity);
//
//    }

    @Test
    public void should_find_all_students() {
        StudentEntity studentEntity = instance().get();
        List<StudentEntity> studentEntities = Collections.singletonList(studentEntity);
        when(studentRepo.findAll()).thenReturn(studentEntities);
        assertEquals(studentEntity, studentService.findAll().get(0));
    }


    @Test
    public void findByIdTestNullId() {
        Assertions.assertThrows(IdNullException.class, () -> this.studentService.findById(null));
    }

    @Test
    public void findByIdTestNotExistId() {
        Assertions.assertThrows(EntityNotFoundExceptionById.class,
                () -> this.studentService.findById(2L));
    }

    @Test
    public void findByIdTestExistId() {
        when(studentRepo.findById(12L)).thenReturn(instance());
        when(studentRepo.existsById(12L)).thenReturn(true);
        String name = this.studentService.findById(12L).getName();
        assertEquals(name,"Hesam");
    }


    //TODO is that a correct way to test?
    @Test
    public void should_delete_student_by_id() {
        int sizeBeforeDelete = studentService.findAll().size();
        doNothing().when(studentRepo).deleteById(4L);
        when(studentRepo.existsById(4L)).thenReturn(true);
        studentService.delete(4L);
        int sizeAfterDelete = studentService.findAll().size();
        assertEquals(sizeBeforeDelete,sizeAfterDelete);
    }

    @Test
    public void deleteNotExistTest() {
        Assertions.assertThrows(EntityNotFoundExceptionById.class,
                () -> this.studentService.delete(5L));
    }


    @Test
    public void existByIdFalseTest() {
        when(this.studentRepo.existsById(6L)).thenReturn(false);
        boolean checkExist = this.studentService.existsById(6L);
        assertFalse(checkExist);
    }

    @Test
    public void existByIdTrueTest() {
        when(this.studentRepo.existsById(1L)).thenReturn(true);
        boolean checkExist = this.studentService.existsById(1L);
        assertTrue(checkExist);
    }

    @Test
    public void existByIdNullIdTest() {
        Assertions.assertThrows(IdNullException.class, () -> this.studentService.existsById(null));
    }

    @Test
    public void should_save_student() {
        StudentEntity studentEntity = instance().get();
        studentEntity.setId(44L);
        when(studentRepo.save(studentEntity)).thenReturn(studentEntity);
        assertEquals(studentEntity, studentService.save(studentEntity));
    }

    @Test
    public void should_update_student() {
        StudentEntity studentEntity = instance().get();
        when(studentRepo.findById(studentEntity.getId())).thenReturn(Optional.of(studentEntity));
        when(studentRepo.save(studentEntity)).thenReturn(studentEntity);
        assertEquals(studentEntity, studentService.update(studentEntity));
    }

    @Test
    public void find_Student_By_CoursesId_nullId_Test(){
        Assertions.assertThrows(IdNullException.class,
                () -> this.studentService.findStudentEntitiesByCoursesId(null));
    }

    @Test
    public void find_Student_By_CoursesId_Test(){
        StudentEntity studentEntity = instance2();
        List<StudentEntity> studentEntities = Collections.singletonList(studentEntity);
        when(studentRepo.findStudentEntitiesByCoursesId(1L)).thenReturn(studentEntities);
        assertEquals(studentEntity, studentService.findStudentEntitiesByCoursesId(1L).get(0));
    }

}

