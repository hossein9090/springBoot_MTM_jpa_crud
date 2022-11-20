package com.hossein.springboot_coursestudenttrain.repo;

import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Long> {

}
