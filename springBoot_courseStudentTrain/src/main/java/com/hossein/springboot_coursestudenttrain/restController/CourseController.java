package com.hossein.springboot_coursestudenttrain.restController;


import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import com.hossein.springboot_coursestudenttrain.mapper.CourseMapper;
import com.hossein.springboot_coursestudenttrain.model.CourseModel;
import com.hossein.springboot_coursestudenttrain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    //TODO
    // ask that which type i must to return in add and update(because of using twice from mapping):

    @PostMapping("/add")
    public CourseModel addCourse(@RequestBody CourseModel courseModel) {
        return courseMapper.convertToModel(courseService.save(courseMapper.convertToEntity(courseModel)));
    }

    @PutMapping("/update")
    public CourseModel updateCourse(@RequestBody CourseModel courseModel) {
        return courseMapper.convertToModel(courseService.update(courseMapper.convertToEntity(courseModel)));
    }

    @GetMapping("/get/{id}")
    public CourseModel getCourse(@PathVariable Long id) {
        return courseMapper.convertToModel(courseService.findById(id));
    }

    @GetMapping("/findAll")
    public List<CourseModel> findAllCourse() {
        return courseMapper.convertListToListModel(courseService.findAll());
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }
}
