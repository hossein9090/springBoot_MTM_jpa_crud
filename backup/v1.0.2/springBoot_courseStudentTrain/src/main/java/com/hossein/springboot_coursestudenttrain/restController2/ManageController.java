//package com.hossein.springboot_coursestudenttrain.restController2;
//
//import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
//import com.hossein.springboot_coursestudenttrain.repo.CourseRepo;
//import com.hossein.springboot_coursestudenttrain.repo.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/manage")
//public class ManageController {
//
//    @Autowired
//    private StudentRepo studentRepo;
//
//    @Autowired
//    private CourseRepo courseRepo;
//
////    retrieve all courses of a student :
//
//    @GetMapping("/students/{studentId}/courses")
//    public ResponseEntity<List<CourseEntity>> getAllCoursesByStudentId(@PathVariable(value = "studentId") Long studentId) {
//        if (!studentRepo.existsById(studentId)) {
//            System.out.println("RuntimeException");
//            throw new RuntimeException();
//        }
//        List<CourseEntity> courses = courseRepo.findCoursesByStudentsId(studentId);
//        return new ResponseEntity<>(courses, HttpStatus.OK);
//    }
//
//
////    create or add course for a student :
//
//    @PostMapping("/students/{studentId}/courses")
//    public ResponseEntity<CourseEntity> addCourse(@PathVariable(value = "studentId") Long studentId, @RequestBody CourseEntity courseEntity) {
//        CourseEntity course = studentRepo.findById(studentId).map(student -> {
//            long courseId = courseEntity.getId();
//
//            // course is existed
//            if (courseId != 0L) {
//                CourseEntity _course = courseRepo.findById(courseId)
//                        .orElseThrow(() -> new RuntimeException());
//                student.addCourse(_course);
//                studentRepo.save(student);
//                return _course;
//            }
//
//            // add and create new course
//            student.addCourse(courseEntity);
//            return courseRepo.save(courseEntity);
//        }).orElseThrow(() -> new RuntimeException());
//
//        return new ResponseEntity<>(course, HttpStatus.CREATED);
//    }
//}
