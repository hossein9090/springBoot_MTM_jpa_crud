package com.hossein.springboot_coursestudenttrain.service;


import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<StudentEntity> findAll();

    public StudentEntity save(StudentEntity studentEntity);

    public StudentEntity findById(Long id);

    public void delete(Long id);

    public StudentEntity update(StudentEntity studentEntity);
}
