package com.hossein.springboot_coursestudenttrain.service;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    public List<CourseEntity> findAll();

    public CourseEntity save(CourseEntity courseEntity);

    public CourseEntity findById(Long id);

    public Optional<CourseEntity> findByIdOptional(Long id);

    public void delete(Long id);

    public CourseEntity update(CourseEntity courseEntity);

    List<CourseEntity> findCoursesByStudentsId(long studentId);

    public boolean existsById(Long id);

}
