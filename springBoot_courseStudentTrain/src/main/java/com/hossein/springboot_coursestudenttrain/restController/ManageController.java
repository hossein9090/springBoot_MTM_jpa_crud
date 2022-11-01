package com.hossein.springboot_coursestudenttrain.restController;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import com.hossein.springboot_coursestudenttrain.mapper.CourseMapper;
import com.hossein.springboot_coursestudenttrain.mapper.StudentMapper;
import com.hossein.springboot_coursestudenttrain.model.CourseModel;
import com.hossein.springboot_coursestudenttrain.model.StudentModel;
import com.hossein.springboot_coursestudenttrain.service.CourseService;
import com.hossein.springboot_coursestudenttrain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

//    retrieve all courses of a student :

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<CourseModel>> getAllCoursesByStudentId(@PathVariable(value = "studentId") Long studentId) {
        if (!studentService.existsById(studentId)) {
            throw new RuntimeException();
        }
        List<CourseModel> courses = courseMapper.convertListToListModel(courseService.findCoursesByStudentsId(studentId));
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


//    create or add course for a student :


    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<CourseModel> addCourse(@PathVariable(value = "studentId") Long studentId, @RequestBody CourseModel courseModel) {

        CourseEntity courseEntity = courseMapper.convertToEntity(courseModel);

        CourseEntity course = studentService.findByIdOptional(studentId).map(student -> {
            long courseId = courseEntity.getId();

            // course is existed
            if (courseId != 0L) {
                CourseEntity _course = courseService.findByIdOptional(courseId)
                        .orElseThrow(() -> new RuntimeException());
//                student.addCourse(_course);
                student.getCourses().add(_course);
                studentService.save(student);
                return _course;
            }

            // add and create new course
//            student.addCourse(courseEntity);
            student.getCourses().add(courseEntity);
            return courseService.save(courseEntity);
        }).orElseThrow(() -> new RuntimeException());

        CourseModel resultCourse = courseMapper.convertToModel(course);

        return new ResponseEntity<>(resultCourse, HttpStatus.CREATED);
    }


//    retrieve all students of a course

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<StudentModel>> getAllStudentsByCourseId(@PathVariable(value = "courseId") Long courseId) {
        if (!courseService.existsById(courseId)) {
            throw new RuntimeException();
        }
        List<StudentModel> students = studentMapper.convertListToListModel(studentService.findStudentEntitiesByCoursesId(courseId));

        return new ResponseEntity<>(students, HttpStatus.OK);
    }


//    delete a course from a student by id :

    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourseFromStudent(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        StudentEntity student = studentService.findByIdOptional(studentId)
                .orElseThrow(() -> new RuntimeException());

//        student.removeCourse(courseId);

        studentService.removeCourse(studentId,courseId);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
