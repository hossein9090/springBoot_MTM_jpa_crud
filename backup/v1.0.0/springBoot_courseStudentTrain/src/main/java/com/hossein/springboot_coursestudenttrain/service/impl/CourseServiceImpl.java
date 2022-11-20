package com.hossein.springboot_coursestudenttrain.service.impl;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import com.hossein.springboot_coursestudenttrain.repo.CourseRepo;
import com.hossein.springboot_coursestudenttrain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<CourseEntity> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public CourseEntity save(CourseEntity courseEntity) {
        return courseRepo.save(courseEntity);
    }

    @Override
    public CourseEntity findById(Long id) {
        return courseRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public CourseEntity update(CourseEntity courseEntity) {
        CourseEntity existingCourseEntity = courseRepo.findById(courseEntity.getId()).orElse(null);
        existingCourseEntity.setName(courseEntity.getName());
        return courseRepo.save(existingCourseEntity);
    }
}
