package com.springboot.UniversityCrudDto.mapper;


import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.dto.groupdto.GroupDto;
import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface DepartmentMapper {

    @Mapping(
            target = "departmentName",
            source = "departmentName"
    )
    DepartmentDto mapDepartmentEntityToDto(Department department);


}
