package com.hossein.springboot_coursestudenttrain.service.impl;


import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import com.hossein.springboot_coursestudenttrain.repo.StudentRepo;
import com.hossein.springboot_coursestudenttrain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

//    @Autowired
//    private StudentRepo studentRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        return studentRepo.save(studentEntity);
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public StudentEntity findById(Long id) {
        StudentEntity byId = studentRepo.findById(id).get();
        return byId;
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        StudentEntity existStudentEntity = studentRepo.findById(studentEntity.getId()).orElse(null);
        existStudentEntity.setName(studentEntity.getName());
        return studentRepo.save(existStudentEntity);
    }


}
