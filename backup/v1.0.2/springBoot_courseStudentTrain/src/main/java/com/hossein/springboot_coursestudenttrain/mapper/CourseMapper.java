package com.hossein.springboot_coursestudenttrain.mapper;

import com.hossein.springboot_coursestudenttrain.entity.CourseEntity;
import com.hossein.springboot_coursestudenttrain.model.CourseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseEntity convertToEntity(CourseModel courseModel);

    CourseModel convertToModel(CourseEntity courseEntity);

    List<CourseModel> convertListToListModel(List<CourseEntity> courseEntityList);

    List<CourseEntity> convertListToListEntity(List<CourseModel> courseModelList);
}
