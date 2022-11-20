package com.hossein.springboot_coursestudenttrain.restController;


import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import com.hossein.springboot_coursestudenttrain.mapper.StudentMapper;
import com.hossein.springboot_coursestudenttrain.model.StudentModel;
import com.hossein.springboot_coursestudenttrain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    //TODO
    // ask that which type i must to return in add and update(because of using twice from mapping):

    @PostMapping("/add")
    public StudentEntity addStudent(@RequestBody StudentModel studentModel) {
        return studentService.save(studentMapper.convertToEntity(studentModel));
    }

    @PutMapping("/update")
    public StudentEntity updateStudent(@RequestBody StudentModel studentModel) {
        return studentService.update(studentMapper.convertToEntity(studentModel));
    }

    @GetMapping("/get/{id}")
    public StudentModel getStudent(@PathVariable Long id) {
        return studentMapper.convertToModel(studentService.findById(id));
    }

    @GetMapping("/findAll")
    public List<StudentModel> findAllStudents() {
        return studentMapper.convertListToListModel(studentService.findAll());
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }

//    @GetMapping("/manage")
//    public void manageTest() {
//
//        return studentMapper.convertToModel(studentService.findById(id));
//    }
}
