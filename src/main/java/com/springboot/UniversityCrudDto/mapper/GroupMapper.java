package com.springboot.UniversityCrudDto.mapper;


import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.dto.groupdto.GroupDepartmentByIdDto;
import com.springboot.UniversityCrudDto.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface GroupMapper {

    @Mapping(
            target = "groupName",
            source = "groupName"
    )
    GroupDepartmentByIdDto mapGroupEntityToDto(Long group);


    DepartmentDto mapGroupEntityToDto(Group grp);
}
