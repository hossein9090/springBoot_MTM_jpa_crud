package com.hossein.springboot_coursestudenttrain.repo;

import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<StudentEntity,Long> {
    List<StudentEntity> findStudentEntitiesByCoursesId(Long courseId);
}
