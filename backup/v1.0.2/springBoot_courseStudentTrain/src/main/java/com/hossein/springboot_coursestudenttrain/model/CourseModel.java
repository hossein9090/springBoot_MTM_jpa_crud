package com.hossein.springboot_coursestudenttrain.model;

import java.util.HashSet;
import java.util.Set;

public class CourseModel {
    private Long id;
    private String name;
    private Set<StudentModel> students = new HashSet<>();

    public CourseModel(Long id, String name, Set<StudentModel> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public CourseModel() {
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

    public Set<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentModel> students) {
        this.students = students;
    }
}
