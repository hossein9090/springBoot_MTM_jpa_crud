package com.hossein.springboot_coursestudenttrain.model;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;

import java.util.HashSet;
import java.util.Set;

public class StudentModel {
    private Long id;
    private String name;
    private Set<CourseModel> courses = new HashSet<>();

    public StudentModel(Long id, String name, Set<CourseModel> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public StudentModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseModel> courses) {
        this.courses = courses;
    }

    public void addCourse(CourseModel courseModel) {
        this.courses.add(courseModel);
//        courseModel.getStudents().add(this);
    }

    public void removeCourse(long tagId) {
        CourseModel courseModel = this.courses.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
        if (courseModel != null) {
            this.courses.remove(courseModel);
//            courseModel.getStudents().remove(this);
        }
    }
}
