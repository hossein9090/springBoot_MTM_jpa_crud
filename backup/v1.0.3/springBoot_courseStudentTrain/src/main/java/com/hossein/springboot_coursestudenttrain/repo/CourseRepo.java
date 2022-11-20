package com.hossein.springboot_coursestudenttrain.repo;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity,Long> {
    List<CourseEntity> findCoursesByStudentsId(long studentId);
}
