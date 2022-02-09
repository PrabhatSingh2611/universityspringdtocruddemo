package com.springboot.UniversityCrudDto.mapper;


import com.springboot.UniversityCrudDto.dto.studentdto.StudentDto;
import com.springboot.UniversityCrudDto.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface StudentMapper  {
    @Mapping(
            target = "firstName",
            source = "name"
    )
    @Mapping(
            target = "surName",
            source = "surname"
    )
    @Mapping(
            target = "age",
            source = "age"
    )
    default StudentDto mapStudentEntityToDto(Student s) {

        return mapStudentEntityToDto(s);
    }


}
