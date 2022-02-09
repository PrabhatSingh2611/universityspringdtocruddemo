package com.springboot.UniversityCrudDto.mapper.mapping;

import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapping {
    public Department deptDtoToEntity(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getDepartmentName());
        return department;
    }

    public DepartmentDto deptEntityToDto(Department addDepartment) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName(addDepartment.getDepartmentName());
        return departmentDto;
    }


}
