package com.hossein.springboot_coursestudenttrain.service;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    public List<CourseEntity> findAll();

    public CourseEntity save(CourseEntity courseEntity);

    public CourseEntity findById(Long id);

    public void delete(Long id);

    public CourseEntity update(CourseEntity courseEntity);

}
