package com.hossein.springboot_coursestudenttrain.mapper;


import com.hossein.springboot_coursestudenttrain.entity.StudentEntity;
import com.hossein.springboot_coursestudenttrain.model.StudentModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentEntity convertToEntity(StudentModel studentModel);

    StudentModel convertToModel(StudentEntity studentEntity);

    List<StudentModel> convertListToListModel(List<StudentEntity> studentEntityList);

    List<StudentEntity> convertListToListEntity(List<StudentModel> studentModelList);
}
