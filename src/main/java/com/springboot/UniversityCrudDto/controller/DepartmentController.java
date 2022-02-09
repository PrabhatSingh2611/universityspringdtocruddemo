package com.springboot.UniversityCrudDto.controller;


import com.springboot.UniversityCrudDto.dto.departmentdto.DepartmentDto;
import com.springboot.UniversityCrudDto.entity.Department;
import com.springboot.UniversityCrudDto.exception.DataNotFoundException;
import com.springboot.UniversityCrudDto.mapper.DepartmentMapper;
import com.springboot.UniversityCrudDto.mapper.mapping.DepartmentMapping;
import com.springboot.UniversityCrudDto.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/university/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentMapping departmentMapping;


    @PostMapping(path = "/create")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto) throws DataNotFoundException {
        Department department = departmentMapping.deptDtoToEntity(departmentDto);
        Department addingdepartmentToDto = departmentService.addDepartment(department);
        return departmentMapping.deptEntityToDto(addingdepartmentToDto);
    }

    @GetMapping(path = "/get")
    public List<DepartmentDto> getAllDepartment() {
        List<Department> department = departmentService.getAllDepartment();
        return (List<DepartmentDto>) department.stream()
                .map(dept -> departmentMapper.mapDepartmentEntityToDto(dept).collect(Collectors.toList()));
    }

    @PutMapping(path = "{departmentIdToUpdate}")
    public void updateDepartment(@RequestBody DepartmentDto departmentDto, @RequestParam Department departmentIdToUpdate) throws DataNotFoundException {
        Department editdepartment = departmentMapping.deptDtoToEntity(departmentDto);
        departmentService.updateDepartment(departmentDto,departmentIdToUpdate);
    }

    @DeleteMapping(path = "{departmentIdToDelete")
    public DepartmentDto deleteDepartment(@PathVariable Long departmentIdToDelete) throws DataNotFoundException {
        Department department = departmentService.deleteDepartment(departmentIdToDelete);
        return departmentMapping.deptEntityToDto(department);
    }


}
