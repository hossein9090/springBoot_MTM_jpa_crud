package com.hossein.springboot_coursestudenttrain.controller;



import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import com.hossein.springboot_coursestudenttrain.mapper.StudentMapper;
import com.hossein.springboot_coursestudenttrain.model.StudentModel;
import com.hossein.springboot_coursestudenttrain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired(required = false)
    private StudentService studentService;

    @Autowired(required = false)
    private StudentMapper studentMapper;

    @GetMapping("/list")
    public String studentList(Model theModel){
        List<StudentModel> studentModels = studentMapper.convertListToListModel(studentService.findAll());
        theModel.addAttribute("students", studentModels);
        return "student/student-list";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        StudentModel studentModel = new StudentModel();
        theModel.addAttribute("student", studentModel);
        return "student/student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") StudentModel theStudentModel) {
        studentService.save(studentMapper.convertToEntity(theStudentModel));
        return "redirect:/student/list";
    }

    @GetMapping("/update")
    public String updateStudent(@RequestParam("studentId") Long studentId,Model theModel) {
        StudentModel studentModel = studentMapper.convertToModel(studentService.findById(studentId));
        theModel.addAttribute("studentModel", studentModel);
        return "student/student-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") Long studentId) {
        studentService.delete(studentId);
        return "redirect:/student/list";
    }

}
